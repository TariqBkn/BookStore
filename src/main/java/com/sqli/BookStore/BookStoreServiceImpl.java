package com.sqli.BookStore;

import java.util.NoSuchElementException;
import java.util.Set;

public class BookStoreServiceImpl implements BookStoreService {

    private Store store;

    public BookStoreServiceImpl(Store store) {
        this.store=store;
    }


    @Override
    public Set<Book> searchByKey(String key) {
        return store.searchByKey(key);
    }

    @Override
    public Set<BookCopy> findBookCopies(int bookId) {
        return store.findBookCopies(bookId);
    }

    @Override
    public Location preOrder(int bookCopyId) {
        return store.preOrder(bookCopyId);
    }

    @Override
    public boolean confirmOrder(int bookCopyId, int customerId) {
                store.removeCopy(bookCopyId);
        return store.confirmOrder(bookCopyId,customerId);

    }

    @Override
    public Set<Book> findBooksByKey(String key) {
        return store.findBooksByKey(key);
    }

    @Override
    public boolean checkStock(int bookId) {
        return store.checkStock(bookId);
    }

    @Override
    public BookCopy findCopyInStore(int id) throws NoSuchElementException {
        return store.findCopy(id);
    }

    @Override
    public boolean isAvailable(BookCopy copy) {
        return store.isAvailable(copy);
    }
}

