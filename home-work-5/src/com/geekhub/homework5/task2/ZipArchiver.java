package com.geekhub.homework5.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchiver {

    public void archive(List<File> files, String filePath, String pathForArchiving) {
        byte[] buffer = new byte[1024];

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath))){
            System.out.println("Output to Zip : " + filePath);

            for (File file : files) {
                String relativePath = file.getAbsolutePath().substring(pathForArchiving.length()+1);
                System.out.println("File Added : " + relativePath);
                ZipEntry zipEntry = new ZipEntry(relativePath);
                zipOutputStream.putNextEntry(zipEntry);

                FileInputStream fileInputStream = new FileInputStream(file);

                int len;
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
                fileInputStream.close();
            }
            zipOutputStream.closeEntry();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    private void generateFileList(File node) {
//
//        if (node.isFile()) {
//            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
//        }
//        if (node.isDirectory()) {
//            String[] subNote = node.list();
//            if (subNote != null) {
//                for (String filename : subNote) {
//                    generateFileList(new File(node, filename));
//                }
//            }
//        }
//
//    }
//
//    private String generateZipEntry(String file) {
//        return file.substring(sourceFolder.length() + 1, file.length());
//    }
}