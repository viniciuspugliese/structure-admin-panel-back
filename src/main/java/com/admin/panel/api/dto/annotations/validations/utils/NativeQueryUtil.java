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

	public List<?> queryBuilder(String table, String collumn, String value, String conditions) {
		String sql = "SELECT " + collumn + " FROM " + table + " WHERE " + collumn + " = '" + value + "'";
		
		conditions(sql, conditions);
		
		return entityManager.createNativeQuery(sql).getResultList();
	}
	
	private void conditions(String sql, String conditions) {
		if (conditions == null || conditions.isEmpty()) {
			return;
		}
		
		if (! conditions.matches(".*\\$\\{[a-zA-Z]*\\}.*")) {
			sql += " AND " + conditions;
			return;
		}
		

//		ResetPasswordDTO resetPasswordDTO = (ResetPasswordDTO) InputReaderUtil.getInput();
//		
//		System.out.println(resetPasswordDTO);
		
//		try {
//			ResetPasswordDTO resetPasswordDTO = new ObjectMapper().readValue(request.getReader(), ResetPasswordDTO.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//        Pattern pattern = Pattern.compile("\\$\\{[a-zA-Z]*\\}");
//        Matcher matcher = pattern.matcher(conditions);
//
//        while (matcher.find()) {
//			String variable = matcher.group().replace("${", "").replace("}", "");
//			String value = request.getParameter(variable);
//			conditions.replace(variable, value);
//        }
	}
}
