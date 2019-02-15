package com.admin.panel.api.mails;

import java.util.Date;
import java.util.Map;

public interface Mail {

	public String getTemplate();
	
	public String getTo();
	
	public String getSubject();
	
	public Date getSentDate();
	
	public Map<String, Object> getVariables();
}
