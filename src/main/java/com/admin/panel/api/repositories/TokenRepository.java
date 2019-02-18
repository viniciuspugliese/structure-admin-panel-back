package com.admin.panel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.panel.api.domain.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

	public Integer countByTokenAndTypeAndUserId(String token, Integer type, Integer user_id);

	public Token findByTokenAndTypeAndUserId(String token, Integer type, Integer user_id);

	public Token findByToken(String token);
}
