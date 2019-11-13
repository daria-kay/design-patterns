package com.target;

import com.orm.IDbEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Builder
public class User implements IDbEntity {
    @Setter
    private int id;
    private String login;
    private String name;
    private Date birthDate;
    private Role role;
}
