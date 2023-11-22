package org.writeF;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static String write(String fileName,String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            return "Content has been written to the file.";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}