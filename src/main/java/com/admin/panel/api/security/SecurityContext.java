package com.admin.panel.api.security;

import com.admin.panel.api.security.exception.UnauthorizedException;

public final class SecurityContext {

	private static UserSecurity userSecurity;

	private SecurityContext() {
		
	}
	
	public static UserSecurity getUserSecurityOrFail() {
		if (userSecurity == null) {
			throw new UnauthorizedException("Usuário não autenticado.");
		}
		
		return userSecurity;
	}
	
	public static UserSecurity getUserSecurity() {
		return userSecurity;
	}

	public static void setUserSecurity(UserSecurity userSecurity) {
		SecurityContext.userSecurity = userSecurity;
	}
	
}
