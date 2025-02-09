package com.ust.capstone.user_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ust.capstone.user_service.dao.UserInfoRepository;
import com.ust.capstone.user_service.entity.UserInfoEntity;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    JwtService jwtService;

    @Autowired
    UserInfoRepository userInfoRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserInfoEntity register(UserInfoEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userInfoRepo.saveAndFlush(user);
    }

    public String generateToken(String name) {
        return jwtService.generateToken(name);
    }

    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }

    public UserInfoEntity getUserByUsername(String username) {
        return userInfoRepository.findByUsername(username).orElse(null);
    }

    public long countUsersByRoleId(int roleId) {
        return userInfoRepository.countByRoleId(roleId);
    }
}
