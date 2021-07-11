package com.lrondonprog.bookstore.service;


import com.lrondonprog.bookstore.dto.BookDTO;
import com.lrondonprog.bookstore.dto.MessageResponseDTO;
import com.lrondonprog.bookstore.entity.Book;
import com.lrondonprog.bookstore.exception.BookNotFoundException;
import com.lrondonprog.bookstore.mapper.BookMapper;
import com.lrondonprog.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}