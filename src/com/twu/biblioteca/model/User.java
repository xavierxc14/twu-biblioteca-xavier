package com.twu.biblioteca.model;

public class User {

    private String name;
    private String libraryNumber;
    private String password;
    private String email;
    private String phoneNumber;

    public User(String name, String libraryNumber, String password, String email, String phoneNumber) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User Information:\n" +
                "\tName: " + name + "\n" +
                "\tEmail: " + email + "\n" +
                "\tPhone Number: " + phoneNumber + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
