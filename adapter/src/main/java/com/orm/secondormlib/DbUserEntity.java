package com.orm.secondormlib;

import com.orm.IDbEntity;
import lombok.Data;

@Data
public class DbUserEntity implements IDbEntity {
    private int id;
    private String login;
    private String passwordHash;
    private int infoId;
}
