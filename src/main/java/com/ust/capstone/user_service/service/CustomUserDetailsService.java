package com.ust.capstone.user_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.capstone.user_service.dao.UserInfoRepository;
import com.ust.capstone.user_service.entity.UserInfoEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfoEntity> user = userInfoRepository.findByUsername(username);
		return user.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username/password not valid!"));
	}
}
    

