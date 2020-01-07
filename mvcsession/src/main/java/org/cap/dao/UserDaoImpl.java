package org.cap.dao;

import org.cap.entities.AppUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements IUserDao {

    private Map<Integer, AppUser>store=new HashMap<>();

    public UserDaoImpl(){
        store.put(1,new AppUser(1,"satya","satya"));
        store.put(2,new AppUser(2,"pranav","pranav"));

    }

    @Override
    public boolean credentialsCorrect(int id ,String password){
        AppUser user=store.get(id);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public AppUser findUserById(int id){
        AppUser user=store.get(id);
        return user;
    }
}
