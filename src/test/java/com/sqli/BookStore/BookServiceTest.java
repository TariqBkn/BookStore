package com.sqli.BookStore;


import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;


public class BookServiceTest {

    private BookStoreService bookStoreService;

    @Before
    public void setUp() {
       bookStoreService = new BookStoreServiceImpl(StoreTestFactory.createTestStore());
    }

    @Test
    public void should_find_book_by_name() {
        Set<Book> books = bookStoreService.findBooksByKey("clean code");
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }

    @Test
    public void should_find_book_by_author_name() {
        Set<Book> books = bookStoreService.findBooksByKey("Robert C. Martin");
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }


    @Test
    public void should_find_book_check_stock() {
        Set<Book> books = bookStoreService.findBooksByKey("Robert C. Martin");
        boolean exists = bookStoreService.checkStock(books.stream().findFirst().get().getId());
        assertNotNull(books);
        assertTrue(exists);
    }

    @Test
    public void should_find_available_book_copy_and_location() {
        Set<Book> books = bookStoreService.findBooksByKey("Robert C. Martin");
        BookCopy copy = bookStoreService.findCopyInStore(books.stream().findFirst().get().getId());
        assertNotNull(copy);
        assertTrue(bookStoreService.isAvailable(copy));
        assertNotNull(copy.getLocation());
    }

    @Test
    public void should_confirm_order_and_assigne_copy_to_customer() {
        Customer customer = new Customer();
        Set<Book> books = bookStoreService.findBooksByKey("Robert C. Martin");
        BookCopy copy = bookStoreService.findCopyInStore(books.stream().findFirst().get().getId());
        bookStoreService.confirmOrder(copy.getId(), customer.getId());
        assertFalse(bookStoreService.isAvailable(copy));
    }
}