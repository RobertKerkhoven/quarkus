package eu.datagraphics.dto;

import eu.datagraphics.entity.Bookstore;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Version;

public class BookstoreDto {

    @JsonbProperty("Id")
    public Long id;

    @JsonbProperty("Bookname")
    public String bookname;

    @JsonbProperty("Author")
    public String author;

    @JsonbProperty("Year")
    public Integer year;

    @Version
    private Long version; // hidden from JSON

    public BookstoreDto(Bookstore entity) {
        this.id = entity.getId();
        this.bookname = entity.getBookname();
        this.author = entity.getAuthor();
        this.year = entity.getYear();
        this.version = entity.getVersion();
    }

}

