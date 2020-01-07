package com.mycompany.app;

public class ServiceImpl implements Service {
    private Dao dao;

    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public AppUser getUserByUsername(String username) {
        AppUser user = dao.getUserByUsername(username);
        return user;
    }

    @Override
    public boolean credentialsCorrect(String username, String password) {
        boolean correct = dao.credentialsCorrect(username, password);
        return correct;
    }
}
