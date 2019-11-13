package com.orm.secondormlib;

import com.orm.IDbEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DbUserEntity implements IDbEntity {
    private int id;
    private String login;
    private String passwordHash;
    private int infoId;
}
