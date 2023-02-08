package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String email;
//    @ManyToMany(mappedBy = "authors")
//    private List<Book> booksAuthored;
}
