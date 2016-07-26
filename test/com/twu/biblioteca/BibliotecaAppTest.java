package com.twu.biblioteca;

import com.twu.biblioteca.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void welcomeMessage() throws Exception {
        assertEquals(BibliotecaApp.WELCOME, app.welcomeMessage());
    }

    @Test
    public void menuOptions() throws Exception {
        String menu = readMenu();
        app.menuOptions();
        assertEquals(menu, out.toString());
    }

    @Test
    public void getMenuOption() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, app.getMenuOption());
    }

    @Test
    public void invalidMenuOption() throws Exception {
        assertEquals(BibliotecaApp.INVALID_OPTION, app.invalidMenuOption());
    }

    @Test
    public void repeatMenu() throws Exception {
        String menu = readMenu();
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        app.repeatMenu();
        assertEquals(menu + "\n", out.toString());
    }

    private String readMenu() {
        List<String> menu = FileUtil.load(BibliotecaApp.MENU_FILE);
        StringBuilder sb = new StringBuilder();
        for (String line : menu) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}