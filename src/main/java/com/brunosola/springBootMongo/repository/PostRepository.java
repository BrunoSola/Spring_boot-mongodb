package com.brunosola.springBootMongo.repository;

import com.brunosola.springBootMongo.domain.Post;
import com.brunosola.springBootMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
