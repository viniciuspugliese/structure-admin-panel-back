package com.admin.panel.api.services.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.data.domain.Sort.Direction;

import com.admin.panel.api.services.exceptions.InvalidParameterException;

public class PaginationUtil {
	
	private static final String[] directions = {"ASC", "DESC"};

	public static Integer normalizePage(Integer page) {
		if (page < 0) {
			throw new InvalidParameterException("linesPerPage", "O valor [" + page + "] é inválido. Aceitos: Valores maiores que 0.");
		}
		
		if (page != 0) {
			page -= 1;
		}
		
		return page;
	}

	public static Direction normalizeDirection(String direction) {
		direction = direction.toUpperCase();
		
		if (! ArrayUtils.contains(directions, direction)) {
			throw new InvalidParameterException("direction", "O valor [" + direction + "] é inválido para ordenação. Aceitos: ASC, DESC.");
		}
		
		return Direction.valueOf(direction);
	}

	public static Integer normalizeLinesPerPage(Integer linesPerPage) {
		if (linesPerPage < 1) {
			throw new InvalidParameterException("linesPerPage", "O valor [" + linesPerPage + "] é inválido. Aceitos: Valores maiores que 0.");
		}
		
		return linesPerPage;
	}
}
