package com.springboot.angular.panel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.angular.panel.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional(readOnly=true)
	@Query(value = "SELECT e FROM #{#entityName} e WHERE e.deletedAt IS NOT NULL")
	public User findByEmail(String email);
}
