package eu.datagraphics.dto;

public class BookstoreUpdateDto {

    public String bookname;
    public String author;
    public Integer year;
    public Long version; // required for optimistic locking
}

