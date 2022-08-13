package org.example.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


public class Users {
    @Basic
    @Column(name = "NAME")
    private Object name;
    @Id
    @Column(name = "ID")
    private long id;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
