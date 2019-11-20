package com.client;

import com.orm.IDbEntity;
import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User implements IDbEntity {
    private DbUserEntity userEntity;
    private DbUserInfoEntity userInfo;

    @Override
    public int getId() {
        return userEntity.getId();
    }
}
