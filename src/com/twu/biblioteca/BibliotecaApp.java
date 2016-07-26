package com.twu.biblioteca;

import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static final String INVALID_OPTION = "Select a valid option!";
    public static final String WELCOME = "Welcome customer!";
    public static final String MENU_FILE = System.getProperty("user.dir") + File.separator +
            "resources" + File.separator + "menu.txt";
    private List<Book> books;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.populateBooks();
        System.out.println(app.welcomeMessage());
        app.repeatMenu();
    }

    public void options(int option) {
        switch (option) {
            case 1:
                showTableHeaders();
                listAllBooks();
                break;
            default:
                System.out.println(invalidMenuOption());
                break;
        }
    }

    public String welcomeMessage() {
        return WELCOME;
    }

    public void showTableHeaders() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|Book title\t\t\t\t\t\t\t\t|\tAuthor\t\t|\tYear|");
        System.out.println("-----------------------------------------------------------------");
    }

    public void listAllBooks() {
        for (Book b : books) {
            b.print();
        }
    }

    public void menuOptions() {
        List<String> lines = FileUtil.load(MENU_FILE);
        for (String s : lines) {
            System.out.println(s);
        }
    }

    public int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        menuOptions();
        return scanner.nextInt();
    }

    public void populateBooks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2003);
        Book book = new Book("Test-driven Development: By Example", new Author("Kent Beck"), calendar.getTime());
        books = new ArrayList<Book>();
        books.add(book);
    }

    public String invalidMenuOption() {
        return INVALID_OPTION;
    }

    public void repeatMenu() {
        int option = getMenuOption();
        while (option != 0) {
            options(option);
            option = getMenuOption();
        }
    }
}
