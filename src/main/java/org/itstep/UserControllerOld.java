package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class UserControllerOld {

    @Autowired
    private UserServiceOld userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public void changeUser(@PathVariable Long id, @RequestBody User user){
        userService.changeUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
