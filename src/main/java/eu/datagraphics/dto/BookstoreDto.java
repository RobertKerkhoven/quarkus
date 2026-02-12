package eu.datagraphics.dto;

import eu.datagraphics.entity.Bookstore;

public class BookstoreDto {

    private Long id;
    private String bookname;
    private String author;
    private Integer year;
    private Long version;

    public BookstoreDto() {
    }

    public BookstoreDto(Long id, String bookname, String author, Integer year, Long version) {
        this.setId(id);
        this.setBookname(bookname);
        this.setAuthor(author);
        this.setYear(year);
        this.setVersion(version);
    }

    // STATIC METHOD TO MAP ENTITY TO DTO
    public static BookstoreDto fromEntity(Bookstore entity) {
        return new BookstoreDto(
                entity.getId(),
                entity.getBookname(),
                entity.getAuthor(),
                entity.getYear(),
                entity.getVersion()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

