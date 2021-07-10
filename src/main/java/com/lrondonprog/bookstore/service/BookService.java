package com.lrondonprog.bookstore.service;


import com.lrondonprog.bookstore.dto.MessageResponseDTO;
import com.lrondonprog.bookstore.entity.Book;
import com.lrondonprog.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .massage("Book created with ID" + savedBook.getId())
                .build();
    }
}
