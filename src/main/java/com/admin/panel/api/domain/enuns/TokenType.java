package com.admin.panel.api.domain.enuns;

public enum TokenType {

	AUTHENTICATION(1, "Autenticação"),
	
	EMAIL(2, "Email");

	private final int value;

	private final String description;

	TokenType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int value() {
		return value;
	}
	
	public String description() {
		return description;
	}

	public static TokenType toEnum(Integer type) {
		if (type == null) {
			return null;
		}
		
		for (TokenType tokenType : TokenType.values()) {
			if (type.equals(tokenType.value())) {
				return tokenType;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + type);
	}
}
