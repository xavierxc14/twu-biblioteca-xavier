package com.twu.biblioteca.service;

import com.twu.biblioteca.factory.MenuFactory;
import com.twu.biblioteca.menu.Menu;

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

    private void displayMenuOptions() {
        Collection<Menu> menus = MenuFactory.getMenuOptions().values();
        System.out.println("Menu:");
        for (Menu menu : menus) {
            System.out.println(menu.getName());
        }
        System.out.print("Select an option: ");
    }

    private int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        displayMenuOptions();
        int option;
        try {
            option = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Only numbers are allowed!");
            option = Integer.MAX_VALUE;
        }
        System.out.println();
        return option;
    }

    public int displayMenu() {
        int option = getMenuOption();
        Menu menuOption = menuFactory.getMenuOption(option);
        menuOption.executeOption();
        System.out.println("\n");
        return option;
    }
}
