package com.reavture.ers.dao;

import java.util.List;

import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;

public interface ReimburseDaoRepository {

	public int addReimburse(Reimburse re);
	public int update(String Status, String id);
	public List<ReimburseEntity> getReimburseEntity(String email);
	public List<ReimburseEntity> getAll();
	public List<ReimburseEntity> getReimburseEntityById(String id);
	public List<ReimburseEntity> approve();
	public List<ReimburseEntity> pending();
	public List<ReimburseEntity> approveById(String email);
	public List<ReimburseEntity> pendingById(String email);
}
