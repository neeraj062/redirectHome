package org.cap.dao;

import org.cap.entities.AppUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements IUserDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean credentialsCorrect(int id, String password) {
        AppUser user = entityManager.find(AppUser.class, id);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public AppUser findUserById(int id) {
        AppUser user = entityManager.find(AppUser.class, id);
        return user;
    }

    @Override
    public AppUser save(AppUser user) {
        user = getEntityManager().merge(user);
        return user;
    }
}
