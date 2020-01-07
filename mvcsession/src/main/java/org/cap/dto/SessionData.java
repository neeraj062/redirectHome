package org.cap.dto;

import org.cap.entities.AppUser;
import org.springframework.stereotype.Component;

public class SessionData {

    private AppUser user;

    public void setUser(AppUser user){
        this.user=user;
    }

    public AppUser getUser(){
        return user;
    }




}
