package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity addUsers(@Valid @RequestBody UserEntity user) {
        userService.addUsers(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(path = "/users", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@Valid @RequestBody UserEntity user) {

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }


    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity listUsers() {
            List<UserEntity> voList = userService.listUsers();
            return ResponseEntity.ok(voList);

    }
}
