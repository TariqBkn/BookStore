package com.sqli.BookStore;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Set;

public class BookStoreServiceTest {

    BookStoreService bookStoreService;

    @Before
    public void setpUp() {

    }

    @Test
    public void should_find_book_by_key() {
        Set<Book> books = bookStoreService.searchByKey("Robert c.");
        Assertions.assertFalse(books.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void should_not_find_book_by_key() {
        Set<Book> books = bookStoreService.searchByKey("dummy");
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    public void should_find_book_copy() {
        Set<BookCopy> bookCopies = bookStoreService.findBookCopies(1);
        Assertions.assertFalse(bookCopies.isEmpty());
    }
}
