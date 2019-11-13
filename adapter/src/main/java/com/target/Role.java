package com.target;

import com.orm.IDbEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Role implements IDbEntity {
    @Setter
    private int id;
    private String roleType;
}
