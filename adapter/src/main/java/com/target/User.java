package com.target;

import com.orm.IDbEntity;

import java.sql.Date;

public class User implements IDbEntity {
    private int id;
    private String login;
    private String name;
    private Date birthDate;
    private Role role;

    public User(int id, String login, String name, Date birthDate, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
    }
    public Role getRole() {
        return role;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
