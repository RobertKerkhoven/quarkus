package eu.datagraphics.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "bookstore")
public class Bookstore extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "bookname", nullable = false, length = 255)
    public String bookname;

    @Column(name = "author", nullable = false, length = 255)
    public String author;

    @Column(name = "year")
    public Integer year;

    @Version
    public Long version;

    // Required by JPA
    public Bookstore() {
    }

    public Bookstore(String bookname, String author, Integer year, Long version) {
        this.bookname = bookname;
        this.author = author;
        this.year = year;
        this.version =  version;
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

    public void setVersion(Long version) {
        this.version = version;
    }
}

