package com.geekhub.homework5.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

    public List<File> getFilesByExtensions(File directory, String... extensions) {
        List<File> files = new ArrayList<>();

        if(directory.isDirectory()) {
            for (File f : directory.listFiles()) {
                files.addAll(getFilesByExtensions(f, extensions));
            }
        }

        if(directory.isFile()) {
            for (String ext : extensions) {
                if(directory.getName().endsWith(ext)) {
                    files.add(directory);
                }
            }
        }

        return files;
    }
}