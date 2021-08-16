package reimbursement;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.reavture.ers.dao.implementation.UserDaoImplementation;
import com.revature.ers.entity.UserEntity;

public class GetAllUser {

	@Test
	public void test() {
		
		UserDaoImplementation u = new UserDaoImplementation();
		List<UserEntity> list = u.getAllUser();
		assertNotNull(list);		
	}
	
	public void getUserById() {
		
		UserDaoImplementation u = new UserDaoImplementation();
		List<UserEntity> list = u.getUser("kirithi@gmail.com");
		assertNotNull(list);
	}
}
