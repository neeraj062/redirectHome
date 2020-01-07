package org.cap.service;

import org.cap.entities.AppUser;

public interface IUserService {
    boolean credentialsCorrect(int id, String password);

    AppUser findUserById(int id);

    AppUser save(AppUser user);
}
