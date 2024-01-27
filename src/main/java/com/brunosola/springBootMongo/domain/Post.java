package com.brunosola.springBootMongo.domain;

import com.brunosola.springBootMongo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Post implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
