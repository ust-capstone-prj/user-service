package com.ust.capstone.user_service.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.capstone.user_service.entity.UserInfoEntity;

public class CustomUserDetails  implements UserDetails {

	private String name;
	private String password;

	public CustomUserDetails(UserInfoEntity user) {
		this.name = user.getUsername();
		this.password = user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
    }}
