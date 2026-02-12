package eu.datagraphics;


import eu.datagraphics.dto.BookstoreDto;
import eu.datagraphics.entity.Bookstore;
import eu.datagraphics.repository.BookstoreRepository;
import eu.datagraphics.service.BookstoreService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/bookstore")
@Produces(MediaType.APPLICATION_JSON)
public class BookstoreResource {

    @Inject
    BookstoreService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookstoreDto getBookById(@PathParam("id") Long id) {
        return service.getBookById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookstoreDto> getBooks() {
        return service.getAllBooks();
    }

}
