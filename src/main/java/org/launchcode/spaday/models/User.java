package org.launchcode.spaday.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private int id;
    private static int nextId = 1;

    private String username;
    private String email;
    private String password;
    private String date;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        date = new SimpleDateFormat("MM-dd-yyyy hh:mm zzz").format(new Date());
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
