package com.geekhub.homework5.task2;

import java.io.File;
import java.io.FilenameFilter;

public class FileExtensionFilter implements FilenameFilter {

    private String ext;

    public FileExtensionFilter(String extention) {
        this.ext = extention;
    }

    public boolean accept(File dir, String name) {
        return (name.endsWith(ext));
    }
}
