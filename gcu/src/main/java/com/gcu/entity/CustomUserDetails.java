package com.gcu.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails{
	
	//create a custom constructor for copying the contructor from Users
	public CustomUserDetails(final Users users) {
		super(users);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// this will be assigning the roles for Authorization to certain pages using SimpleGrantedAuthority
		return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE"+role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {

		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
