package com.argenbet.app.restfullAPIArgenbet.Service;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.User;
import com.argenbet.app.restfullAPIArgenbet.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user){
        return this.repository.save(user);
    }

    public List<User> findAll(){
        return this.repository.findAll();
    }

    public void delete(Long id){
        Optional<User> optionalUser=this.repository.findById(id);
        if(optionalUser.isEmpty()){

        }
        this.repository.deleteById(id);
    }

    public void updateUser(Long id, User user){
        User updatedUser=repository.findById(id).get();
        updatedUser.setGender(user.getGender());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setPhone(user.getPhone());
        repository.save(updatedUser);
    }

    public User findByMail(String mail){
        return repository.findByEmail(mail);
    }
}
