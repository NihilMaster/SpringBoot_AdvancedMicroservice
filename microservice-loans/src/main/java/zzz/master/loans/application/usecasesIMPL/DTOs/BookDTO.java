package zzz.master.loans.application.usecasesIMPL.DTOs;

import lombok.Data;

@Data
public class BookDTO {
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
