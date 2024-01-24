package com.brunosola.springBootMongo.resources;

import com.brunosola.springBootMongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //Identifica que a classe será um recurso REST
@RequestMapping(value = "/users") // Caminho do endpoint da aplicação. http://localhost:8080/users
public class UserResource {
    @GetMapping //Idenfitica que o método será do tipo GET.
    public ResponseEntity<List<User>> findAll(){ //ResponseEntity é uma classe Spring Web, utilizada para representar resposta HTTP(pode ser personalizado).
        User maria = new User("1", "maria silva", "maria@gmail.com");
        User alex = new User("2", "alex silva", "alex@gmail.com");

        //Instancia a lista e adiciona maria e alex.
        List<User> users = new ArrayList<>(Arrays.asList(maria, alex));

        /* Passo a Passo da execução acima.
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(maria, alex));
         */
        return ResponseEntity.ok().body(users);
    }
}
