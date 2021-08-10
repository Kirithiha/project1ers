package com.revature.ers.mapper;

import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;
import com.revature.ers.entity.UserEntity;

public class ReimburseMapper {

	public static ReimburseEntity mapReimburse(Reimburse r) {
		
		ReimburseEntity re = new ReimburseEntity();
		re.setType(r.getType());
		re.setReason(r.getReason());
		re.setAmount(Double.parseDouble(r.getAmount()));
		re.setPurchasedDate(r.getDate());
		re.setAppliedDate();
		re.setStatus();
		UserEntity u = new UserEntity();
		u.setEmailid(r.getEmailid());
		re.setUser(u);
		return re;
	}
}
