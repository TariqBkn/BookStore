package com.sqli.BookStore;

import java.util.List;

public class Store {

    private final List<BookCopy> bookCopies;

    public Store(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }
}
