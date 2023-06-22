package com.example.jpaproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BooksRepository booksRepository;

private int counter = 0;
    @GetMapping(value="/hello")
    public void method(){
        counter++;
        Book book = new Book();
        book.setId(counter);
        book.setName("code");
        book.setAuthor("man");
        booksRepository.save(book);

    }
}
