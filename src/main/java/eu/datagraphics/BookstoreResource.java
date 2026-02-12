package eu.datagraphics;


import eu.datagraphics.entity.Bookstore;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/bookstore")
public class BookstoreResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Bookstore> getBooks() {

        List<Bookstore> books = em.createQuery("from Bookstore", Bookstore.class).getResultList();

        return books;
    }

}
