package com.brunosola.springBootMongo.services;


import com.brunosola.springBootMongo.domain.Post;
import com.brunosola.springBootMongo.repository.PostRepository;
import com.brunosola.springBootMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired //Injeção de dependência automatica do Spring
    private PostRepository postRepository;
    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found!"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }
}
