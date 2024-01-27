package com.brunosola.springBootMongo.repository;

import com.brunosola.springBootMongo.domain.Post;
import com.brunosola.springBootMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
