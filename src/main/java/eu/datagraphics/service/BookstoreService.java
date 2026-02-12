package eu.datagraphics.service;

import eu.datagraphics.dto.BookstoreDto;
import eu.datagraphics.repository.BookstoreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookstoreService {

    @Inject
    BookstoreRepository repository;

    // Map all entities to DTOs using streams
    public List<BookstoreDto> getAllBooks() {
        return new ArrayList<>(repository.findAll()
                .stream()
                .map(BookstoreDto::fromEntity)
                .toList());
    }

    // Map single entity to DTO
    public BookstoreDto getBookById(Long id) {
        return repository.findByIdOptional(id)       // Optional<Bookstore>
                .stream()
                .map(BookstoreDto::fromEntity)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }




}
