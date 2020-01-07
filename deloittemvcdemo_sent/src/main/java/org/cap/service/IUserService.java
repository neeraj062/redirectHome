package org.cap.service;

import org.cap.entities.Employee;

public interface IUserService {
	Employee  findById(int id);
	boolean credentialsCorrect(int id, String name);
}
