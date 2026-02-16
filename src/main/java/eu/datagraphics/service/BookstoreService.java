package eu.datagraphics.service;

import eu.datagraphics.dto.BookstoreDto;
import eu.datagraphics.dto.BookstoreUpdateDto;
import eu.datagraphics.entity.Bookstore;
import eu.datagraphics.repository.BookstoreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookstoreService {

    @Inject
    BookstoreRepository repository;

    @PersistenceContext
    EntityManager em;

    // Map all entities to DTOs using streams
    public List<BookstoreDto> getAllBooks() {
        return new ArrayList<>(repository.findAll()
                .stream()
                .map(BookstoreDto::new)
                .collect(Collectors.toList()));
    }

    // Map single entity to DTO
    public BookstoreDto getBookById(Long id) {
        return repository.findByIdOptional(id)       // Optional<Bookstore>
                .stream()
                .map(BookstoreDto::new)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Transactional
    public Bookstore update(Long id, BookstoreUpdateDto dto) {
        Bookstore detached = new Bookstore();
        detached.id = id;
        detached.version = dto.version;
        detached.bookname = dto.bookname;
        detached.author = dto.author;
        detached.year = dto.year;

        return em.merge(detached); // Panache uses merge internally
    }

}
