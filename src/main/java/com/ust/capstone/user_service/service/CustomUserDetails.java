package com.ust.capstone.user_service.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.capstone.user_service.entity.UserInfoEntity;
import com.ust.capstone.user_service.pojo.RoleInfoPojo;

public class CustomUserDetails  implements UserDetails {

	private String name;
	private String password;
	private List<SimpleGrantedAuthority> allRoles;

	public CustomUserDetails(UserInfoEntity user, RoleInfoPojo roleInfo) {
		this.name = user.getUsername();
		this.password = user.getPassword();
		// this.roles = user.getRoleId();
		this.allRoles = Arrays.asList(new SimpleGrantedAuthority(roleInfo.getRoleName()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
return allRoles;		

	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
    }}
