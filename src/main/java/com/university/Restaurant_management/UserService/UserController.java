package com.university.Restaurant_management.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/AddUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> User= userService.getAllUser();
        return new ResponseEntity<>(User, HttpStatus.OK);
    }
    @PutMapping("/{idUser}")

    public User updateUser(@PathVariable Long idUser, @RequestBody User userDetails){
        return userService.UpadteUser(idUser, userDetails);
    }

    @DeleteMapping("/{idUser}")

    public ResponseEntity<?> deleteUser(@PathVariable Long idUser ){
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }
}
