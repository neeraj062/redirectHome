package com.mycompany.app;

public interface Dao {
    AppUser getUserByUsername(String username);

    boolean credentialsCorrect(String username, String password);
}
