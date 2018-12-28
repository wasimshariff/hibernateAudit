package com.example.demo.service;


import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public void addUsers(UserEntity vo) {
        usersRepository.save(vo);
    }

    public void updateUser(UserEntity vo) {
        usersRepository.save(vo);
    }

    public List<UserEntity> listUsers() {
        List<UserEntity> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }



}
