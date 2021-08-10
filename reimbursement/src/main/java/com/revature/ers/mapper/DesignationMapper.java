package com.revature.ers.mapper;

import com.revature.ers.dto.Designation;
import com.revature.ers.entity.DesignationEntity;

public class DesignationMapper {

	public static DesignationEntity mapDesignation(Designation d) {
		
		DesignationEntity de = new DesignationEntity();
		de.setName(d.getName());
		return de;
	}
}
