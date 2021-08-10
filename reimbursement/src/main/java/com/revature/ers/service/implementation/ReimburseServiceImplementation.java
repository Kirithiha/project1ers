package com.revature.ers.service.implementation;

import java.util.List;

import com.reavture.ers.dao.implementation.ReimburseDaoImplementation;
import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;
import com.revature.ers.service.ReimburseServiceRepository;

public class ReimburseServiceImplementation implements ReimburseServiceRepository{

	ReimburseDaoImplementation r_impl = new ReimburseDaoImplementation();
	
	@Override
	public int addReimburse(Reimburse re) {
		
		return r_impl.addReimburse(re);
	}

	@Override
	public int update(String Status, String id) {
		
		return r_impl.update(Status, id);
	}

	@Override
	public int delete(String emailid) {
		
		return r_impl.delete(emailid);
	}

	@Override
	public List<ReimburseEntity> getReimburseEntity(String email) {
		
		return r_impl.getReimburseEntity(email);
	}

	@Override
	public List<ReimburseEntity> getAll() {
		
		return r_impl.getAll();
	}

	@Override
	public List<ReimburseEntity> getReimburseEntityById(String id) {
		
		return r_impl.getReimburseEntityById(id);
	}

	@Override
	public List<ReimburseEntity> approve() {
		
		return r_impl.approve();
	}

	@Override
	public List<ReimburseEntity> pending() {
		
		return r_impl.pending();
	}

	@Override
	public List<ReimburseEntity> approveById(String email) {
		
		return r_impl.approveById(email);
	}

}
