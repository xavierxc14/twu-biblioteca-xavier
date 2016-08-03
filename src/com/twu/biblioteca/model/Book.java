package com.twu.biblioteca.model;

public class Book {
    private String name;

    private String author;

    private String yearOfPublication;

    private User userCheckedOut;

    public Book(String name, String author, String yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("|%50s|%20s|%20s|", getName(), getAuthor(), getYearOfPublication());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public User getUserCheckedOut() {
        return userCheckedOut;
    }

    public void setUserCheckedOut(User userCheckedOut) {
        this.userCheckedOut = userCheckedOut;
    }
}
