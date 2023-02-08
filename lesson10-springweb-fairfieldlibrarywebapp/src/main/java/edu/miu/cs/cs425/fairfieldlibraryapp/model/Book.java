package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="books")
@NamedQuery(name="Book.getLowFeesBooks", query = "select b from Book b where b.overdueFee < ?1")
@NamedNativeQuery(name="Book.findBookByISBN", query="select * from books b where b.isbn = ?1")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable = false)
//    @NotNull(message = "ISBN cannot be null")
//    @NotEmpty(message = "ISBN cannot be empty string or null")
    @NotBlank(message = "ISBN cannot be blank or empty or null")
    private String isbn;
    @Column(nullable = false)
    private String title;
    private LocalDate datePublished;
    private Integer numberOfCopies;
    @Embedded
    private Money overdueFee;

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = true)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name="books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name="author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

}
