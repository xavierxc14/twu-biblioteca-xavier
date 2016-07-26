package com.twu.biblioteca;

import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static final String WELCOME = "Welcome customer!";
    public static final String INVALID_OPTION = "Select a valid option!";
    public static final String CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";

    private static final String PATH = System.getProperty("user.dir") + File.separator +
            "resources" + File.separator;

    public static final String MENU_FILE = PATH + "menu.txt";
    public static final String BOOK_FILE = PATH + "book.txt";

    private BookService bookService = new BookService();

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.bookService.populateBooks();
        System.out.println(app.welcomeMessage());
        app.repeatMenu();
    }

    private void options(int option) {
        switch (option) {
            case 1:
                showTableHeaders();
                bookService.listAllBooks();
                break;
            case 2:
                System.out.println("Write the book name:");
                Scanner scanner = new Scanner(System.in);
                String bookName = scanner.nextLine().trim();
                Book searched = bookService.findBookByName(bookName);
                bookService.checkoutBook(searched);
                break;
            default:
                System.out.println(invalidMenuOption());
                break;
        }
    }

    public String welcomeMessage() {
        return WELCOME;
    }

    private void showTableHeaders() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|Book title\t\t\t\t\t\t\t\t|\tAuthor\t\t|\tYear|");
        System.out.println("-----------------------------------------------------------------");
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
