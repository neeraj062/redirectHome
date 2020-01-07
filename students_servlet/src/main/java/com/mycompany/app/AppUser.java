package com.mycompany.app;

public class AppUser {

    public AppUser() {

    }

    public AppUser(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AppUser)) {
            return false;
        }
        AppUser user = (AppUser) obj;
        return user.username.equals(this.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
