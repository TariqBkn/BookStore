package com.sqli.BookStore;

import java.util.Set;

public interface BookStoreService {

    Set<Book> searchByKey(String key);

    Set<BookCopy> findBookCopies(int bookId);

    Location preOrder(int bookCopyId);

    boolean confirmOrder(int bookCopyId, int customerId);

    Set<Book>  findBooksByKey(String key);

    boolean checkStock(int bookId);

    BookCopy findCopyInStore(int id);

    boolean isAvailable(BookCopy copy);
}
