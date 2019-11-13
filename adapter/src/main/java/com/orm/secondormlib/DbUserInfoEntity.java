package com.orm.secondormlib;


import com.orm.IDbEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class DbUserInfoEntity implements IDbEntity {
    private int id;
    private String name;
    private Date birthDate;
}
