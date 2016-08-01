package com.twu.biblioteca.service;

import com.twu.biblioteca.factory.MenuFactory;
import com.twu.biblioteca.model.Menu;

import java.util.Collection;
import java.util.Scanner;

public class MenuService {

    private static final String WELCOME = "Welcome customer!";

    private final MenuFactory menuFactory;

    public MenuService() {
        menuFactory = new MenuFactory();
    }

    public String displayWelcomeMessage() {
        return WELCOME;
    }

    public void displayMenuOptions() {
        Collection<Menu> menus = MenuFactory.getMenuOptions().values();
        System.out.println("Menu:");
        for (Menu menu : menus) {
            System.out.println(menu.getName());
        }
        System.out.print("Select an option: ");
    }

    public int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        displayMenuOptions();
        int option = Integer.MAX_VALUE;
        try {
            option = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Only numbers are allowed");
        }
        System.out.println();
        return option;
    }

    public void displayMenuUntilQuit() {
        int option = getMenuOption();
        while (option != 0) {
            Menu menuOption = menuFactory.getMenuOption(option);
            menuOption.executeOption();
            System.out.println("\n");
            option = getMenuOption();
        }
    }
}
