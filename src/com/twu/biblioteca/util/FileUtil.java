package com.twu.biblioteca.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /**
     * Read a file and creates a list where every line is an element.
     *
     * @param fileName The file name.
     * @return A list containing the lines of the file.
     */
    public static List<String> load(String fileName) {
        List<String> lines = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("I/O Problem!");
            e.printStackTrace();
        }
        return lines;
    }
}
