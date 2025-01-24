package com.ust.capstone.user_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.capstone.user_service.entity.UserInfoEntity;
import com.ust.capstone.user_service.pojo.UserRoleTokenPojo;
import com.ust.capstone.user_service.service.JwtService;
import com.ust.capstone.user_service.service.UserInfoService;

@RestController
@RequestMapping("/api/auth")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    // @GetMapping("/users")
    // public ResponseEntity<List<UserInfoEntity>> getAlUsers(){
    //     return new ResponseEntity<List<UserInfoEntity>>(userInfoService.getAllUsers(),HttpStatus.OK);
    // }

    // @GetMapping("/users/{username}")
    // public ResponseEntity<UserInfoEntity> getUserByUsername(@PathVariable String username){
    //     return new ResponseEntity<UserInfoEntity>(userInfoService.getUserByUsername(username), HttpStatus.OK);
    // }

    // @PostMapping("/users")
    // public ResponseEntity<UserInfoEntity> addUser(@RequestBody UserInfoEntity userInfoEntity){
    //     return new ResponseEntity<UserInfoEntity>(userInfoService.addUser(userInfoEntity), HttpStatus.OK);
    // }

    // @GetMapping("/users/roles")
    // public ResponseEntity<List<Map<String, Object>>> getAllUsersWithRoles() {
    //     return ResponseEntity.ok(userInfoService.getAllUsersWithRoles());
    // }

    // @GetMapping("/users/roles/{id}")
    // public ResponseEntity<Map<String, Object>> getUserWithRole(@PathVariable int id) {
    //     Map<String, Object> userWithRole = userInfoService.getUserWithRole(id);
    //     if (userWithRole == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(userWithRole);
    // }

    @Autowired
	JwtService jwtService;

	@Autowired
	private UserInfoService userCredService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public UserInfoEntity register(@RequestBody UserInfoEntity user) {
		return userCredService.register(user);
	}

	@GetMapping("/validate/token")
	public boolean validateToken(@RequestParam String token) {
		return userCredService.verifyToken(token);
	}

	@PostMapping("/validate/user")
	public UserRoleTokenPojo getToken(@RequestBody UserInfoEntity user) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authenticate.isAuthenticated()) {
            String role = authenticate
                            .getAuthorities()
                            .stream()
                            .map((eachRole)->eachRole.toString())
                            .toList()
                            .get(0);
            return new UserRoleTokenPojo(user.getUsername(), role , jwtService.generateToken(user.getUsername()));
			//return userCredService.generateToken(user.getUsername());
		}
		return null;
	}

    

}
