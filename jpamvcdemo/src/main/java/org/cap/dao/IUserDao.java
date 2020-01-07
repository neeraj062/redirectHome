package org.cap.dao;

import org.cap.entities.AppUser;

public interface IUserDao {
    boolean credentialsCorrect(int id, String password);

    AppUser findUserById(int id);

    AppUser save(AppUser user);
}
