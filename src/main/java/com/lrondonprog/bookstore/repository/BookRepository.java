package com.lrondonprog.bookstore.repository;

import com.lrondonprog.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
