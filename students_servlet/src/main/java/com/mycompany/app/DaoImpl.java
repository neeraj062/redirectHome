package com.mycompany.app;

import java.util.HashMap;
import java.util.Map;

public class DaoImpl implements Dao{

    private Map<String, AppUser> store = new HashMap<>();

    public DaoImpl() {
        AppUser user1 = new AppUser("satya", "1234",21);
        store.put("satya", user1);
        AppUser user2 = new AppUser("pranav", "678",21);
        store.put("pranav", user2);
    }

    @Override
    public boolean credentialsCorrect(String username, String password) {
        AppUser user = store.get(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        AppUser user = store.get(username);
        return user;
    }

}
