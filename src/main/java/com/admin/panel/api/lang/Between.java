package com.admin.panel.api.lang;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.admin.panel.api.lang.exceptions.InvalidBetweenException;
import com.admin.panel.api.services.util.DateTimeUtil;

public class Between<T> implements Serializable {
	private static final long serialVersionUID = -8437502652334130154L;

	private T initial;
	
	private T finale;
	
	public Between() {
	}

	public Between(T initial, T finale) {
		super();
		this.initial = initial;
		this.finale = finale;
	}

	public boolean validate(String dateFormat) throws ParseException {
		if (dateFormat != null) {
			return validate((String) initial, (String) finale, dateFormat);
		}
		
		if (initial instanceof Integer) {
			return validate((Integer) initial, (Integer) finale);
		}
		
		if (initial instanceof Date) {
			return validate((Date) initial, (Date) finale);
		}

		throw new InvalidBetweenException("The type [" + initial.getClass().getTypeName() + "] is invalid. Types accepted: String, Integer, Date.");
	}
	
	public Boolean in(T value) { 
		if (value instanceof Integer) {
			return compare((Integer) value);
		}
		
		if (value instanceof Date) {
			return compare((Date) value);
		}

		throw new InvalidBetweenException("The type [" + value.getClass().getTypeName() + "] is invalid. Types accepted: String, Integer, Date.");
	}

	private boolean validate(String initial, String finale, String format) throws ParseException {

		Date initialCasted = DateTimeUtil.createFromFormat(format, initial);
		Date finaleCasted = DateTimeUtil.createFromFormat(format, finale);
		
		return initialCasted.equals(finaleCasted) || initialCasted.before(finaleCasted);
	}

	private boolean validate(Date initial, Date finale) {
		return initial.after(finale);
	}

	private boolean validate(Integer initial, Integer finale) {
		return initial <= finale;
	}

	private Boolean compare(Date value) {
		Date initialCasted = (Date) initial;
		Date finaleCasted = (Date) finale;
		
		return value.after(initialCasted) && value.before(finaleCasted);
	}

	private Boolean compare(Integer value) {
		Integer initialCasted = (Integer) initial;
		Integer finaleCasted = (Integer) finale;
		
		return value >= initialCasted && value <= finaleCasted;
	}

	public T getInitial() {
		return initial;
	}

	public void setInitial(T initial) {
		this.initial = initial;
	}

	public T getFinale() {
		return finale;
	}

	public void setFinale(T finale) {
		this.finale = finale;
	}
}
