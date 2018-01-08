package com.mitrais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;

public class Java7ResourceManagement {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "G:\\update.txt"));
             java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(FileSystems.getDefault()
                     .getPath("G:\\update.txt"), Charset.defaultCharset())) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
