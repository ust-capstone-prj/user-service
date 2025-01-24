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

    // private final String ROLE_SERVICE_URL = "http://localhost:1313/api/roles";

    // public List<UserInfoEntity> getAllUsers() {
    //     return userInfoRepository.findAll();
    // }

    // public UserInfoEntity getUserByUsername(String username) {
    //     return userInfoRepository.findByUsername(username).orElse(null);
    // }

    // public UserInfoEntity addUser(UserInfoEntity newUser){
    //     return userInfoRepository.saveAndFlush(newUser);
    // }
    
    // public Map<String, Object> getUserWithRole(int userId) {
    //     // Fetch user info
    //     UserInfoEntity user = userInfoRepository.findById(String.valueOf(userId)).orElse(null);
    //     if (user == null) {
    //         return null;
    //     }

    //     // Fetch role info from RoleService
    //     String roleUrl = ROLE_SERVICE_URL + "/" + user.getRoleId();
    //     Object roleInfo = restTemplate.getForObject(roleUrl, Object.class);

    //     // Combine UserInfoEntity and roleInfoPojo into a response map
    //     return Map.of(
    //         "user", user,
    //         "role", roleInfo
    //     );
    // }

    // public List<Map<String, Object>> getAllUsersWithRoles() {
    //     List<UserInfoEntity> users = userInfoRepository.findAll();

    //     return users.stream().map(user -> {
    //         // Fetch role info for each user
    //         String roleUrl = ROLE_SERVICE_URL + "/" + user.getRoleId();
    //         Object roleInfo = restTemplate.getForObject(roleUrl, Object.class);

    //         // Combine UserInfoEntity and roleInfoPojo into a response map
    //         return Map.of(
    //             "user", user,
    //             "role", roleInfo
    //         );
    //     }).collect(Collectors.toList());
    // }
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
    }
