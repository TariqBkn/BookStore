package com.sqli.BookStore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCopy {

    private Book book;

    private int id;

    private Location location;


    public BookCopy(int id, Book book, Location location){
        this.book=book;
        this.id=id;
        this.location=location;
    }

    public int getBookId(){
        return book.getId();
    }

    public String getBookAuthorName(){
        return book.getAuthorName();
    }

    public String getBookTitle(){
        return book.getTitle();
    }

    public boolean IsKeyMatchingBookCopyInformation(String key) {
        return isKeyEqualToAuthorName(key) || isKeyEqualToBookTitle(key);
    }
    private boolean isKeyEqualToBookTitle(String key) {
        return this.getBookTitle().equalsIgnoreCase(key);
    }

    private boolean isKeyEqualToAuthorName(String key) {
        return this.getBookAuthorName().equalsIgnoreCase(key);
    }
}