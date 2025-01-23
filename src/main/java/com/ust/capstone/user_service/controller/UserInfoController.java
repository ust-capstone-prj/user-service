package com.ust.capstone.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.capstone.user_service.entity.UserInfoEntity;
import com.ust.capstone.user_service.service.UserInfoService;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/users")
    public ResponseEntity<List<UserInfoEntity>> getAlUsers(){
        return new ResponseEntity<List<UserInfoEntity>>(userInfoService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserInfoEntity> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<UserInfoEntity>(userInfoService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserInfoEntity> addUser(@RequestBody UserInfoEntity userInfoEntity){
        return new ResponseEntity<UserInfoEntity>(userInfoService.addUser(userInfoEntity), HttpStatus.OK);
    }
    
}
