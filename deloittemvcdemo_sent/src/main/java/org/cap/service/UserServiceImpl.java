package org.cap.service;

import org.cap.dao.IUserDao;
import org.cap.entities.Employee;
import org.cap.exception.InCorrectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cap.entities.*;


@Service
public class UserServiceImpl implements IUserService{
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Employee findById(int no)throws InCorrectIdException {
		if(no<0)
		{
			throw new InCorrectIdException("Mobile no is incorrect.");
		}
		Employee c=userDao.findById(no);
		return c;
	}

	@Override
	public boolean credentialsCorrect(int id, String name) {
		return userDao.credentialsCorrect(id, name);
	}
	


}
