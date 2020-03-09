package com.sqli.BookStore.endpoint;

import com.sqli.BookStore.Book;
import com.sqli.BookStore.BookStoreService;
import com.sqli.BookStore.BookStoreServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class StoreController {


    private BookStoreService bookStoreService = new BookStoreServiceImpl(StoreTestFactory.createTestStore());

    @GetMapping("/book/search/{key}")
    @ResponseBody
    public Set<Book> search(@PathVariable("key") String key) {
        return bookStoreService.findBooksByKey(key);
    }
}
