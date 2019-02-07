package com.springboot.angular.panel.interceptors;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

@Component
public class JpaInterceptor extends EmptyInterceptor {
	private static final long serialVersionUID = 437005770360701100L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		// TODO 
		
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}
	
	@Override
	@Modifying
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		super.onDelete(entity, id, state, propertyNames, types);
	}
	
	@Override
	public String onPrepareStatement(String sql) {
		if (! sql.toUpperCase().startsWith("SELECT")) {
			return super.onPrepareStatement(sql);			
		}
		
		// TODO 
		
		return super.onPrepareStatement(sql);
	}
}
