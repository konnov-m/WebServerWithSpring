package org.example.models;

public class User {
    private long id;
    private String name;

    public User() {};
    public User(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
