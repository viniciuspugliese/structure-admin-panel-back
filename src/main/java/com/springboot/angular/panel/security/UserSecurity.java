package com.springboot.angular.panel.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.angular.panel.domain.Role;
import com.springboot.angular.panel.domain.User;

public class UserSecurity implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String email;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSecurity() {
		
	}

	public UserSecurity(User user) {
		super();
		id = user.getId();
		email = user.getEmail();
		password = user.getPassword();
		this.authorities = user.getRoles().stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList());
	}

	public UserSecurity(Integer id, String email, String password, List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public boolean hasRole(Role role) {
		return getAuthorities().contains(new SimpleGrantedAuthority(role.getName()));
	}
}
