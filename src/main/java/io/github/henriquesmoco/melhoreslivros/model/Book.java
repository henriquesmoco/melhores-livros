package io.github.henriquesmoco.melhoreslivros.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @NotNull @Size(max=15)
    private String isbn;

    @NotNull @Size(min = 3)
    private String name;

}
