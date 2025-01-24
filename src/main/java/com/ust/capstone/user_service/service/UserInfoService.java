package com.ust.capstone.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.capstone.user_service.dao.UserInfoRepository;
import com.ust.capstone.user_service.entity.UserInfoEntity;

@Service
public class UserInfoService {
    

    
    @Autowired
    UserInfoRepository userInfoRepository;

    public List<UserInfoEntity> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfoEntity getUserByUsername(String username) {
        return userInfoRepository.findById(username).orElse(null);
    }

    public UserInfoEntity addUser(UserInfoEntity newUser){
        return userInfoRepository.saveAndFlush(newUser);
    }
    
}
