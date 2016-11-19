package com.geekhub.homework5.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        File file = new File(pathToSource);
        return file.exists();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder fileContent = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToSource))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                fileContent.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}
