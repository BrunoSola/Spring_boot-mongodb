package com.brunosola.springBootMongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document
@Getter @Setter @NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true) //Anotação para dizer que essa coleção é uma referência, e o parâmetro Lazy utilizado para não chamar todos os post sempre acessar um User, somente quando solicitado.
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
