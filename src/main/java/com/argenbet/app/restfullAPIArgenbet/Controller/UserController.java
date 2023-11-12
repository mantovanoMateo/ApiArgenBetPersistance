package com.argenbet.app.restfullAPIArgenbet.Controller;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.User;
import com.argenbet.app.restfullAPIArgenbet.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }
    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("/{email}")
    User findByMail(@PathVariable("email") String mail){
        return this.userService.findByMail(mail);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user){
        this.userService.updateUser(id,user);
        return "user updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        this.userService.delete(id);
        return "user deleted";
    }




}
