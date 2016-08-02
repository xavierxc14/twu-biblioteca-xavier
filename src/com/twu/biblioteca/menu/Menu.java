package com.twu.biblioteca.menu;

public abstract class Menu {

    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public abstract void executeOption();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
