package com.geekhub.homework5;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Наталия on 19.11.2016.
 */
@XmlRootElement(name = "Translation")
public class TranslationResponse {

    private int code;
    String lang;
    String text;

    public int getCode() {
        return code;
    }

    @XmlAttribute
    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    @XmlAttribute
    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    @XmlElement
    public void setText(String text) {
        this.text = text;
    }
}
