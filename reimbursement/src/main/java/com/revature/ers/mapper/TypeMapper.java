package com.revature.ers.mapper;

import com.revature.ers.dto.Type;
import com.revature.ers.entity.TypeEntity;

public class TypeMapper {
	
	public static TypeEntity mapType(Type t) {
		
		TypeEntity te = new TypeEntity();
		te.setName(t.getName());
		return te;
	}
}
