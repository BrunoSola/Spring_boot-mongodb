package com.brunosola.springBootMongo.services;

import com.brunosola.springBootMongo.domain.User;
import com.brunosola.springBootMongo.dto.UserDTO;
import com.brunosola.springBootMongo.repository.UserRepository;
import com.brunosola.springBootMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id); //Busca o Id, caso não encontrado já lança uma exceção conforme o método.
        userRepository.deleteById(id);
    }
    public User update(User obj){
        User newUserObj = findById(obj.getId());
        updateData(newUserObj, obj);
        return userRepository.save(newUserObj);
    }

    private void updateData(User newUserObj, User obj) {
        newUserObj.setName(obj.getName());
        newUserObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
