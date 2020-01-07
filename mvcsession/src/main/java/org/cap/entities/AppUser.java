package org.cap.entities;

public class AppUser {

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

    public AppUser(int id, String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
}
