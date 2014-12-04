package io.github.henriquesmoco.melhoreslivros.model;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @NotNull
    @Size(min=2)
    private String subject;

    @Size(min = 2)
    @ManyToMany
    private List<Book> candidateBooks;
}
