package org.cap.service;

import org.cap.dao.IUserDao;
import org.cap.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(IUserDao dao) {
        this.userDao = dao;
    }

    @Override
    public boolean credentialsCorrect(int id, String password) {
        return userDao.credentialsCorrect(id, password);
    }

    @Override
    public AppUser findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public AppUser save(AppUser user) {
        return getUserDao().save(user);
    }

    /*
    @PostConstruct
    public void init(){
       AppUser user1=new AppUser("satya","satya");
       userDao.save(user1);
       AppUser user2=new AppUser("pranav","pranav");
       userDao.save(user2);
    }*/
}
