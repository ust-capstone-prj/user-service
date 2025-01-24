package com.ust.capstone.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ust.capstone.user_service.dao.UserInfoRepository;
import com.ust.capstone.user_service.entity.UserInfoEntity;
import com.ust.capstone.user_service.pojo.RoleInfoPojo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfoEntity> user = userInfoRepository.findByUsername(username);

		// feign client to fetch role by role id

		RoleInfoPojo roleInfo = restTemplate.getForObject("http://localhost:1313/api/roles/"+user.get().getRoleId(), RoleInfoPojo.class);
		return user.map((userOptional)-> new CustomUserDetails(userOptional, roleInfo ))
				.orElseThrow(() -> new UsernameNotFoundException("Username/password not valid!"));
	}
}
    

