package org.cap.entities;

import javax.persistence.*;

@Entity
@Table(name = "appusers")
public class AppUser {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public AppUser(){

    }


    public AppUser( String name,String password){
        this.name=name;
        this.password=password;
    }


}
