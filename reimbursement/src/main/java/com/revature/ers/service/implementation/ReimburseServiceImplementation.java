package com.revature.ers.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.reavture.ers.dao.implementation.ReimburseDaoImplementation;
import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;
import com.revature.ers.service.ReimburseServiceRepository;

public class ReimburseServiceImplementation implements ReimburseServiceRepository{

	ReimburseDaoImplementation r_impl = new ReimburseDaoImplementation();
	Logger log = Logger.getLogger("ReimburseServiceImplementation.class");
	
	// TO ADD REIMBURSE.
	@Override
	public int addReimburse(Reimburse re) {
		log.info("Inside ADD REIMBURSE SERVICE");
		return r_impl.addReimburse(re);
	}

	//TO UPDATE REIMBURSE.
	@Override
	public int update(String Status, String id) {
		
		log.info("Inside UPDATE REIMBURSE SERVICE");
		return r_impl.update(Status, id);
	}

	// TO GET REIMBURSE BY EMAILID.
	@Override
	public List<ReimburseEntity> getReimburseEntity(String email) {
		
		log.info("Inside GET REIMBURSE BY EMAIL ID SERVICE");
		return r_impl.getReimburseEntity(email);
	}

	// TO LIST ALL REIMBURSE.
	@Override
	public List<ReimburseEntity> getAll() {
		
		log.info("Inside GET ALL REIMBURSE SERVICE");
		return r_impl.getAll();
	}

	// TO GET REIMBURSE BY ID.
	@Override
	public List<ReimburseEntity> getReimburseEntityById(String id) {
		
		log.info("Inside GET REIMBURSE BY ID SERVICE");
		return r_impl.getReimburseEntityById(id);
	}

	// TO LIST APPROVED REIMBURSE.
	@Override
	public List<ReimburseEntity> approve() {
		
		log.info("Inside APPROVE REIMBURSE SERVICE");
		return r_impl.approve();
	}

	// TO GET PENDING REIMBURSE.
	@Override
	public List<ReimburseEntity> pending() {
		
		log.info("Inside PENDING REIMBURSE SERVICE");
		return r_impl.pending();
	}

	// TO GET APPROVE REIMBURSE BY EMAILID.
	@Override
	public List<ReimburseEntity> approveById(String email) {
		
		log.info("Inside APPROVE REIMBURSE BY ID SERVICE");
		return r_impl.approveById(email);
	}

}
