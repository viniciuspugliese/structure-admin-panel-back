package com.springboot.angular.panel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.panel.domain.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

	public Integer countByTokenAndTypeAndUserId(String token, Integer type, Integer user_id);
}
