package com.orm.secondormlib;

import com.orm.IDbEntity;

public class DbUserEntity implements IDbEntity {
    private int id;
    private String login;
    private String passwordHash;
    private int infoId;

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
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
