package zzz.master.books.infrastructure.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("books")
public class BookEntity {

    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;

    @Column("publication_year")
    private Integer publicationYear;
    private String genre;
    private String description;

    @Column("total_copies")
    private Integer totalCopies;

    @Column("available_copies")
    private Integer availableCopies;
    private String location;;
    private String language;
    private Integer pages;

    @Column("loan_count")
    private Integer loanCount;
}
