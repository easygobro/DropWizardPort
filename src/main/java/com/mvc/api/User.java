package com.mvc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    int id;
    String name;
    String email;
    String password;
    public User(){}

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @JsonProperty
    public int getId() {
        return id;
    }
    @JsonProperty
    public void setId() {
        this.id = id;
    }
    @JsonProperty
    public String getName() {
        return name;
    }
    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty
    public String getEmail() {
        return email;
    }
    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword() {
        this.password = password;
    }

}
