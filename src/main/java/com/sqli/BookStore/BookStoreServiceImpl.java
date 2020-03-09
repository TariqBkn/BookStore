package com.sqli.BookStore;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookStoreServiceImpl implements BookStoreService {

    private final Store store;

    public BookStoreServiceImpl(Store store) {
        this.store = store;
    }

    @Override
    public Set<Book> findBooksByKey(String key) {
        return  store.getBookCopies().stream()
                .filter(copy -> copy.getBook().getAuthor().contains(key) ||
                        copy.getBook().getTitle().contains(key))
                .map(BookCopy::getBook).collect(Collectors.toSet());
    }

    @Override
    public boolean checkStock(int bookId) {
        return findAvailableCopy(bookId).isPresent();
    }

    @Override
    public BookCopy findCopyInStore(int bookId) {
        return findAvailableCopy(bookId)
                .orElseThrow( ()->new RuntimeException("Copy not found"));
    }

    @Override
    public void confirmOrder(BookCopy copy, Customer customer) {
        if(copy.isAvailable()) {
            copy.setCustomer(customer);
            copy.setAvailable(false);
        }else {
            throw new RuntimeException("no copy is available");
        }
    }

    private Optional<BookCopy> findAvailableCopy(int bookId)
    {
        return store.getBookCopies().stream()
                .filter(copy -> copy.getBook().getId()==bookId && copy.isAvailable()).findAny();
    }
}