package com.sqli.BookStore;

import java.util.List;
import java.util.Set;

public interface BookStoreService {

    Set<Book> findBooksByKey(String key);

    boolean checkStock(int bookId);

    BookCopy findCopyInStore(int bookId);

    void confirmOrder(BookCopy copy, Customer customer);

}
