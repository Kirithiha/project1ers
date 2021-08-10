package com.reavture.ers.dao;

import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;

public interface AdminDaoRepository {

	public int addType(Type type);
	public int addDesignation(Designation des);
}
