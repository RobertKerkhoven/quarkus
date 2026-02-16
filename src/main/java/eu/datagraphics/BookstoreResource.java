package eu.datagraphics;


import eu.datagraphics.dto.BookstoreDto;
import eu.datagraphics.dto.BookstoreUpdateDto;
import eu.datagraphics.entity.Bookstore;
import eu.datagraphics.service.BookstoreService;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, BookstoreUpdateDto dto) {

        try {
            Bookstore updated = service.update(id, dto);
            return Response.ok(updated).build();

        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Entity was modified by another user")
                    .build();
        }
    }

}
