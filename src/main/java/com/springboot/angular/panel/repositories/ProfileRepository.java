package com.springboot.angular.panel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.panel.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
