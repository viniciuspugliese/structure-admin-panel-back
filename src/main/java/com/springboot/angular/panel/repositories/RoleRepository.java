package com.springboot.angular.panel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.panel.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
