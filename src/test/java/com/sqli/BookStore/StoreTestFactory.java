<<<<<<< HEAD
package com.sqli.BookStore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StoreTestFactory {

    public static Store createTestStore() {

        Book martinBook = new Book(1, "Robert C. Martin", "clean code");
        List<BookCopy> bookscopies = Stream.of(
                new BookCopy(1, martinBook, new Location("IT 5", "4", "LEFT")),
                new BookCopy(2, martinBook, new Location("IT 6", "2", "RIGHT")) )
                .collect(Collectors.toList());
        return new Store(bookscopies);
    }

}
=======
package com.sqli.BookStore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StoreTestFactory {

    public static Store createTestStore() {
        Book martinBook = new Book(1, "Robert C. martin", "clean code");
        List<BookCopy> bookscopies = Stream.of(
                new BookCopy(1, martinBook, new Location("IT 5", "4", "LEFT")),
                new BookCopy(2, martinBook, new Location("IT 6", "2", "RIGHT")))
                .collect(Collectors.toList());
        return new Store(bookscopies);
    }

}
>>>>>>> 62a4f9c27767dfa5b31b0adfe764c72fa370a4f3
