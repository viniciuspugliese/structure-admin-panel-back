package com.springboot.angular.panel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.angular.panel.domain.User;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

	@Transactional(readOnly=true)
	public User findByEmail(String email);
}
