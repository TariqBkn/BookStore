package com.sqli.BookStore;

public class BookCopy {

    private final int id;

    private final Book book;

    private final Location location;

    private Customer customer;

    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public BookCopy(int id, Book book, Location location) {
        this.id = id;
        this.book = book;
        this.location = location;
        available=true;
    }

    public Book getBook() {
        return book;
    }

    public Location getLocation() {
        return location;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
