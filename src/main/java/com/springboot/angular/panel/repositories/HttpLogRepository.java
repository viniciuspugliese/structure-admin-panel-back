package com.springboot.angular.panel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.panel.domain.HttpLog;

@Repository
public interface HttpLogRepository extends JpaRepository<HttpLog, Integer> {
}
