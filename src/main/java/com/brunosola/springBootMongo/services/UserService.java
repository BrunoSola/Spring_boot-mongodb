package com.brunosola.springBootMongo.services;

import com.brunosola.springBootMongo.domain.User;
import com.brunosola.springBootMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired //Injeção de dependência automatica do Spring
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
