package com.twu.biblioteca.util;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileUtilTest {
    @Test
    public void load() throws Exception {
        List<String> lines = new ArrayList<String>();
        File temp = File.createTempFile("temp", ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        bw.write("Hello");
        bw.write("World");
        assertEquals(lines, FileUtil.load(temp.getAbsolutePath()));
        bw.close();
    }

}