package com.geekhub.homework5.source;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        //TODO: implement me
        return false;
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        //TODO: implement me
        return null;
    }
}
