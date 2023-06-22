package com.example.secondstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BooksRepository booksRepository;
    @GetMapping(value = "/hello")
    public void method(){

        Book book = new Book();
        book.setId(1);
        book.setName("clean code");
        book.setAutorName("robert");
        booksRepository.save(book);

    }
}
