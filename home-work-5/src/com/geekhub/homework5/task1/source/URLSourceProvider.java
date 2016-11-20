package com.geekhub.homework5.task1.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {


    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            URL url = new URL(pathToSource);
            URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder loadedText = new StringBuilder();
        URLConnection connection = null;
        try {
            URL sourceUrl = new URL(pathToSource);
            connection = sourceUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while (in.ready()){
                inputLine = in.readLine();
                loadedText.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedText.toString();
    }
}
