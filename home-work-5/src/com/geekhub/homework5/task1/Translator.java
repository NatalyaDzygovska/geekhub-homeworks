package com.geekhub.homework5.task1;

import com.geekhub.homework5.task1.source.SourceLoadingException;
import com.geekhub.homework5.task1.source.URLSourceProvider;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;

/**
 * Provides utilities for translating texts to russian language.<br/>
 * Uses Yandex Translate API, more information at <a href="http://api.yandex.ru/translate/">http://api.yandex.ru/translate/</a><br/>
 * Depends on {@link URLSourceProvider} for accessing Yandex Translator API service
 */
public class Translator {
    /**
     * Yandex Translate API key could be obtained at <a href="http://api.yandex.ru/key/form.xml?service=trnsl">http://api.yandex.ru/key/form.xml?service=trnsl</a>
     * to do that you have to be authorized.
     */
    private static final String YANDEX_API_KEY =
            "trnsl.1.1.20161117T150610Z.cbc201538e7eed5d.ed6482621b8ae3e3093bc67b5600eeadb5a1924a";
    private static final String TRANSLATION_DIRECTION = "ru";

    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider) {
        this.urlSourceProvider = urlSourceProvider;
    }

    /**
     * Translates text to russian language
     *
     * @param original text to translate
     * @return translated text
     * @throws IOException
     */
    public String translate(String original) throws IOException {
        try {
            return parseContent(urlSourceProvider.load(prepareURL(original)));
        } catch (SourceLoadingException e) {
            throw new IOException(e);
        }
    }

    /**
     * Prepares URL to invoke Yandex Translate API service for specified text
     *
     * @param text to translate
     * @return url for translation specified text
     */
    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text="
                + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    /**
     * Parses content returned by Yandex Translate API service. Removes all tags and system texts. Keeps only translated text.
     *
     * @param content that was received from Yandex Translate API by invoking prepared URL
     * @return translated text
     */
    private String parseContent(String content) throws IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TranslationResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(content);
            TranslationResponse response = (TranslationResponse) unmarshaller.unmarshal(reader);
            return response.getText();
        } catch (JAXBException e) {
            throw new IOException(e);
        }
    }

    /**
     * Encodes text that need to be translated to put it as URL parameter
     *
     * @param text to be translated
     * @return encoded text
     */
    private String encodeText(String text) throws IOException {
        return URLEncoder.encode(text, "UTF-8");
    }
}
