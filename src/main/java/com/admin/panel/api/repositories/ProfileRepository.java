package com.admin.panel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.panel.api.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
