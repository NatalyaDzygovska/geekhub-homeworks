package com.geekhub.homework5.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by Наталия on 20.11.2016.
 */
public class App {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(App.class.getResourceAsStream("/homework5.properties"));
        String sourcePath = properties.getProperty("source.path");
        String outputPath = properties.getProperty("output.path");

        ZipArchiver archiver = new ZipArchiver();
        FileFinder fileFinder = new FileFinder();

        for (String archiveType : properties.getProperty("archive.types").split(",")) {
            System.out.println(archiveType);
            String[] extensions = properties.getProperty("archive.type." + archiveType).split(",");
            List<File> files = fileFinder.getFilesByExtensions(new File(sourcePath), extensions);
            archiver.archive(files, outputPath+archiveType+".zip", sourcePath);
        }



    }
}
