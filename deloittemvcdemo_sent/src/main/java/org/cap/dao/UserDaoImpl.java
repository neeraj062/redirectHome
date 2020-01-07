package org.cap.dao;

import java.util.HashMap;
import java.util.Map;

import org.cap.entities.Employee;
import org.cap.exception.InCorrectIdException;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl  implements IUserDao{
	
	private Map<Integer,Employee> store=new HashMap<>();
	
	public UserDaoImpl() {
		Employee e=new Employee(1,"aggfd");
		store.put(e.getId(),e);
		Employee e2=new Employee(2,"amsnns");
		store.put(e2.getId(),e2);
	}
	
	@Override
	public Employee  findById(int id) {
		Employee e = store.get(id);
		if(id<0) {
			throw new InCorrectIdException("Id is incorrect");
		}
		return e;
	}
	
	@Override
	public boolean credentialsCorrect(int id, String name) {
		 Employee user = store.get(id);
	     System.out.print("inside credentaials, user="+user);   
		 System.out.print(user.getId()+" "+user.getName());
	     if (user== null) {
	            return false;
	        }
	        return user.getName().trim().equals(name.trim());
	}

}
