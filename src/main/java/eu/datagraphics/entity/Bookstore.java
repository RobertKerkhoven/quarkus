package eu.datagraphics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookstore")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookname", nullable = false, length = 255)
    private String bookname;

    @Column(name = "author", nullable = false, length = 255)
    private String author;

    @Column(name = "year")
    private Integer year;

    @Version
    private Long version;

    // Required by JPA
    protected Bookstore() {
    }

    public Bookstore(String bookname, String author, Integer year) {
        this.bookname = bookname;
        this.author = author;
        this.year = year;
    }

    // Getters and setters

    public Long getId() {
        return id;
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
}

