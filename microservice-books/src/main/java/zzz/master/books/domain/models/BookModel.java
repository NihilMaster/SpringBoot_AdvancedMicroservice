package zzz.master.books.domain.models;

import lombok.Data;

@Data
public class BookModel {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer publicationYear;
    private String genre;
    private String description;
    private Integer totalCopies;
    private Integer availableCopies;
    private String location;;
    private String language;
    private Integer pages;
    private Integer loanCount;

}
