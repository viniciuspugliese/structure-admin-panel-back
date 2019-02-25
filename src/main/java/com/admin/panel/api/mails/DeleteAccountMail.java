package com.admin.panel.api.mails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.admin.panel.api.domain.User;

public class DeleteAccountMail implements Mail {

	private User user;
	
	public DeleteAccountMail(User user) {
		this.user = user;
	}
	
	@Override
	public String getTemplate() {
		return "emails/delete-account";
	}

	@Override
	public String getTo() {
		return user.getEmail();
	}

	@Override
	public String getSubject() {
		return "Exclusão da conta";
	}

	@Override
	public Date getSentDate() {
		return new Date(System.currentTimeMillis());
	}
	
	@Override
	public Map<String, Object> getVariables() {
		Map<String, Object> variables = new HashMap<String, Object>();
		
		variables.put("user", user);
		
		return variables;
	}
}
