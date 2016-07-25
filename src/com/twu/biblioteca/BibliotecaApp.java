package com.twu.biblioteca;

import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private List<Book> books;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.populateBooks();
        System.out.println(app.welcomeMessage());
        int option=app.getMenuOption();
        switch (option){
            case 1:
                app.listAllBooks();
                break;
        }
    }

    public String welcomeMessage() {
        return "Welcome customer!";
    }

    public void listAllBooks() {

        for (Book b : books) {
            b.print();
        }
    }

    public void menuOptions() {
        System.out.print("1. List Books");
    }

    public int getMenuOption() {
        System.out.println("Menu:");
        menuOptions();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Select an option: ");
        return keyboard.nextInt();
    }

    public void populateBooks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2003);
        Book book = new Book("Test-driven Development: By Example", new Author("Kent Beck"), calendar.getTime());
        books = new ArrayList<Book>();
        books.add(book);
    }
}
