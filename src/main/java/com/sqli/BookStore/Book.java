package com.sqli.BookStore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private int id;
    private String authorName;
    private String title;

    public Book(int id, String authorName, String title) {
        this.id=id;
        this.authorName=authorName;
        this.title=title;
    }
}
