package com.admin.panel.api.repositories.custom;

import java.text.ParseException;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.admin.panel.api.domain.User;
import com.admin.panel.api.dto.UserFilterDTO;
import com.admin.panel.api.lang.Between;
import com.admin.panel.api.services.util.DateTimeUtil;

public class UserRepositoryImpl extends BaseCustomRepository<User, Integer> implements UserCustomRepository {

	@Override
	public Page<User> search(Pageable pageable, UserFilterDTO userFilterDTO, Direction direction, String sortBy) throws ParseException {
		TypedQuery<User> query = handlerQuery(pageable, userFilterDTO, direction, sortBy);
		return readPage(query, User.class, pageable, (Specification<User>) null);
	}
	
	private TypedQuery<User> handlerQuery(Pageable pageable, UserFilterDTO userFilterDTO, Direction direction, String sortBy) throws ParseException {
		String sql = handlerSql(pageable, userFilterDTO, direction, sortBy);
		
		TypedQuery<User> query = entityManager.createQuery(sql, User.class);
		
		if (userFilterDTO.getName() != null && ! userFilterDTO.getName().isEmpty()) {
			query.setParameter("name", "%" + userFilterDTO.getName() + "%");
		}

		if (userFilterDTO.getEmail() != null && ! userFilterDTO.getEmail().isEmpty()) {
			query.setParameter("email", "%" + userFilterDTO.getEmail() + "%");
		}

		if (userFilterDTO.getCreatedBetween() != null) {
			Between<String> between = userFilterDTO.getCreatedBetween();
			
			if (between.getInitial() != null && ! between.getInitial().isEmpty()) {
				query.setParameter("initial", DateTimeUtil.createFromFormat("dd/MM/yyyy HH:mm:ss", between.getInitial()));
			}

			if (between.getFinale() != null && ! between.getFinale().isEmpty()) {
				query.setParameter("finale", DateTimeUtil.createFromFormat("dd/MM/yyyy HH:mm:ss", between.getFinale()));
			}
		}
		
		return query;
	}

	private String handlerSql(Pageable pageable, UserFilterDTO userFilterDTO, Direction direction, String sortBy) {
		String sql = "SELECT u FROM User u ";
		StringBuilder where = new StringBuilder();
		
		if (userFilterDTO.getName() != null && ! userFilterDTO.getName().isEmpty()) {
			where.append(" u.name LIKE :name AND ");
		}

		if (userFilterDTO.getEmail() != null && ! userFilterDTO.getEmail().isEmpty()) {
			where.append(" u.email LIKE :email AND ");
		}

		if (userFilterDTO.getCreatedBetween() != null) {
			Between<String> between = userFilterDTO.getCreatedBetween();
			
			if (between.getInitial() != null && ! between.getInitial().isEmpty()) {
				where.append(" u.createdAt >= :initial AND ");
			}

			if (between.getFinale() != null && ! between.getFinale().isEmpty()) {
				where.append(" u.createdAt <= :finale AND");
			}
		}
		
		if (where.length() != 0) {
			sql += " WHERE " + where.substring(0, where.length() - 3).toString();
		}

		return sql += " ORDER BY " + sortBy + " " + direction.name();
	}
}
