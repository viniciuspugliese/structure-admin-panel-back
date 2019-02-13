package com.admin.panel.api.dto.annotations.validations.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class NativeQueryUtil {

    @PersistenceContext
    private EntityManager entityManager;

	public NativeQueryUtil() {
		
	}

	public List<?> queryBuilder(String table, String collumn, String field, String conditions) {
		String sql = "SELECT " + collumn + " FROM " + table + " WHERE " + collumn + " = '" + field + "'";
		
		if (conditions != null && ! conditions.isEmpty()) {
			sql += " AND " + conditions;
		}
		
		return entityManager.createNativeQuery(sql).getResultList();
	}
}
