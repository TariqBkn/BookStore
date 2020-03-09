package com.sqli.BookStore;

import lombok.Getter;

@Getter
public class BookOrder implements Order {

    private int bookId;

    private int customerId;

    BookOrder(int bookId, int customerId){
        this.bookId=bookId;
        this.customerId=customerId;
    }

    @Override
    public int getOrderedBookId() {
        return bookId;
    }

    @Override
    public int getCustomerId(){
        return customerId;
    }

}
