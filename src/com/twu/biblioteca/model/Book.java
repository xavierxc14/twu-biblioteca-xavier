package com.twu.biblioteca.model;

import java.util.Calendar;
import java.util.Date;

public class Book {
    private String name;

    private Author author;

    private Date publication;

    private boolean checkedOut;

    public Book() {
    }

    public Book(String name, Author author, Date publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(publication);
        return String.format("|%s\t|\t%s\t|\t%d|", name, author.getName(), calendar.get(Calendar.YEAR));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
