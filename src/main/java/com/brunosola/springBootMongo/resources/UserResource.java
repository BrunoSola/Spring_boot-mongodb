package com.brunosola.springBootMongo.resources;

import com.brunosola.springBootMongo.domain.User;
import com.brunosola.springBootMongo.dto.UserDTO;
import com.brunosola.springBootMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController //Identifica que a classe será um recurso REST
@RequestMapping(value = "/users") // Caminho do endpoint da aplicação. http://localhost:8080/users
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping //Idenfitica que o método será do tipo GET.
    public ResponseEntity<List<UserDTO>> findAll(){ //ResponseEntity é uma classe Spring Web, utilizada para representar resposta HTTP(pode ser personalizado).

        //Busca no banco de dados e guarda na lista.
        List<User> users = userService.findAll();
        //convertendo User em UserDTO
        //UserDTO::new= Esta é uma expressão lambda referindo-se a um construtor da classe 'UserDTO' que tem como argumento um 'User'.
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){ //@PathVariable para informar que o 'id' sera fornecido na url.
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
