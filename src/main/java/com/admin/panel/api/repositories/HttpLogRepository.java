package com.admin.panel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.panel.api.domain.HttpLog;

@Repository
public interface HttpLogRepository extends JpaRepository<HttpLog, Integer> {
}
