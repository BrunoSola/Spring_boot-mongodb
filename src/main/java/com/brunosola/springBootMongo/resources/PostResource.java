package com.brunosola.springBootMongo.resources;

import com.brunosola.springBootMongo.domain.Post;
import com.brunosola.springBootMongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Identifica que a classe será um recurso REST
@RequestMapping(value = "/posts") // Caminho do endpoint da aplicação. http://localhost:8080/users
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){ //@PathVariable para informar que o 'id' sera fornecido na url.
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
