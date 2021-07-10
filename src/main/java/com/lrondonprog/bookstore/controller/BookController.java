package com.lrondonprog.bookstore.controller;

import com.lrondonprog.bookstore.dto.MassageResponseDTO;
import com.lrondonprog.bookstore.entity.Book;
import com.lrondonprog.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("a/api/v1/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MassageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);

    }
}
