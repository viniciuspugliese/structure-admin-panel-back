package com.admin.panel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.repositories.custom.UserCustomRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserCustomRepository {

	@Transactional(readOnly = true)
	public User findByEmail(String email);
}
