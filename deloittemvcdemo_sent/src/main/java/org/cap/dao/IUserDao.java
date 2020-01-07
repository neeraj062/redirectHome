package org.cap.dao;

import org.cap.entities.Employee;

public interface IUserDao {
	//Map<Integer,Empolyee> store = new HashMap<>();
	Employee  findById(int id);
	boolean credentialsCorrect(int id, String name);
	
}
