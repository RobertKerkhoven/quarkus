package eu.datagraphics.dto;

import eu.datagraphics.entity.Bookstore;
import jakarta.json.bind.annotation.JsonbProperty;

public class BookstoreDto {

    @JsonbProperty("Id")
    public Long id;

    @JsonbProperty("Bookname")
    public String bookname;

    @JsonbProperty("Author")
    public String author;

    @JsonbProperty("Year")
    public Integer year;

    public BookstoreDto(Bookstore entity) {
        this.id = entity.getId();
        this.bookname = entity.getBookname();
        this.author = entity.getAuthor();
        this.year = entity.getYear();
    }

}

