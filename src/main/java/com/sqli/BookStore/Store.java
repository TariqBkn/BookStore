package com.sqli.BookStore;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Store {

    private List<BookCopy> booksCopies = new ArrayList<>();

    private List<Order> confirmedOrders = new ArrayList<>();

    public Store(List<BookCopy> booksCopies) {
        this.booksCopies.clear();
        this.booksCopies.addAll(booksCopies);
    }

    public Set<Book> searchByKey(String key){
        return booksCopies.stream().filter(b -> b.IsKeyMatchingBookCopyInformation(key))
                                    .map(b->b.getBook())
                                    .collect(Collectors.toSet());
    }

    public boolean confirmOrder(int bookCopyId, int customerId) {
        return confirmedOrders.add(new BookOrder(bookCopyId, customerId));
    }

    public Location preOrder(int bookCopyId) {
        return streamBookCopies().filter(bookCopy -> bookCopy.getId()==bookCopyId)
                                 .findFirst()
                                 .map(bookCopy -> bookCopy.getLocation())
                                 .get();
    }

    private Stream<BookCopy> streamBookCopies() {
        return this.booksCopies.stream();
    }

    public Set<BookCopy> findBookCopies(int bookId) {
        return streamBookCopies().filter(book -> book.getBookId()==bookId)
                .collect(Collectors.toSet());
    }

    public Set<Book> findBooksByKey(String key) {
        return streamBookCopies().filter(bookCopy ->  bookCopy.IsKeyMatchingBookCopyInformation(key) )
                                 .map(bookCopy-> bookCopy.getBook())
                                 .collect(Collectors.toSet());
    }

    public boolean checkStock(int bookId) {
        return streamBookCopies().anyMatch(bookCopy -> bookCopy.getBookId()==bookId);
    }

    public BookCopy findCopy(int id) {
        return streamBookCopies()
                                 .filter(bookCopy -> bookCopy.getBookId()==id)
                                 .findFirst()
                                 .orElseThrow(() -> new NoSuchElementException("No book copy has the provided Id!"));
    }

    public boolean isAvailable(BookCopy copy) {
        return booksCopies.contains(copy);
    }

    public boolean removeCopy(int bookCopyId) {
        return booksCopies.removeIf(bookCopy -> bookCopy.getBookId()==bookCopyId);
    }
}
