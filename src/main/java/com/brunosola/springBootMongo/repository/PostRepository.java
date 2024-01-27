package com.brunosola.springBootMongo.repository;

import com.brunosola.springBootMongo.domain.Post;
import com.brunosola.springBootMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //?0 = 1º parâmetro do método(no caso String text) - 'i' - ignore case sensitive //https://www.mongodb.com/docs/manual/reference/operator/query/regex/
    List<Post> findByTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
