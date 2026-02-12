package eu.datagraphics.repository;

import eu.datagraphics.entity.Bookstore;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookstoreRepository implements PanacheRepositoryBase<Bookstore, Long> {
}
