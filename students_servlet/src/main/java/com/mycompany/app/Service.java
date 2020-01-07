package com.mycompany.app;

public interface Service {
    AppUser getUserByUsername(String username);

    boolean credentialsCorrect(String username, String password);

}
