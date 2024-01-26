package com.brunosola.springBootMongo.services;

import com.brunosola.springBootMongo.domain.User;
import com.brunosola.springBootMongo.repository.UserRepository;
import com.brunosola.springBootMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //Injeção de dependência automatica do Spring
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found!"));
    }
}
