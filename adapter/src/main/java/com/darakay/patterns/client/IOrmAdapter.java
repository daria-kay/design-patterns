package com.darakay.patterns.client;

import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;

public interface IOrmAdapter {

    User getUserById(int id);

    void saveUser(DbUserEntity userEntity, DbUserInfoEntity userInfo);

    void removeById(int id);
}
