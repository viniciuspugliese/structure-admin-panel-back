package com.springboot.angular.panel.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
	
	@Override
	@Transactional(readOnly = true)
	@Query("select e from #{#entityName} e where e.deletedAt IS NULL")
	List<T> findAll();
	
	@Override
	@Query("select e from #{#entityName} e where e.deletedAt IS NULL")
	Page<T> findAll(Pageable pageable);
	
	@Override
	@Query("select e from #{#entityName} e where e.deletedAt IS NULL")
	List<T> findAll(Sort sort);
	
	@Override
	@Query("select e from #{#entityName} e where e.id in ?1 and e.deletedAt IS NULL")
	List<T> findAllById(Iterable<ID> ids);
}
