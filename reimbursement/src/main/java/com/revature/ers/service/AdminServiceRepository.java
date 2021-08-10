package com.revature.ers.service;

import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;

public interface AdminServiceRepository {

	public int addType(Type type);
	public int addDesignation(Designation des);

}
