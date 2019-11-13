package main.java.com.orm.secondormlib;

import main.java.com.orm.IDbEntity;

import java.sql.Date;

public class DbUserInfoEntity implements IDbEntity {
    private int id;
    private String name;
    private Date birthDate;

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
