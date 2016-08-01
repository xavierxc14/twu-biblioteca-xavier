package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;

public class CheckoutBookOption extends Menu {

    public CheckoutBookOption(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        Book searched = getBookService().obtainBook();
        getBookService().checkoutBook(searched);
    }
}
