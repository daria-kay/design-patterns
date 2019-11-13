package com.target;

import com.orm.IDbEntity;

public class Role implements IDbEntity {
    private int id;
    private String roleType;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
