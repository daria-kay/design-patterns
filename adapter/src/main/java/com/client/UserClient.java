package com.client;

import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;

public class UserClient {
    private IOrmAdapter ormAdapter;

    public UserClient(IOrmAdapter ormAdapter) {
        this.ormAdapter = ormAdapter;
    }

    public User getUserById(int id){
        return ormAdapter.getUserById(id);
    }

    public void addUser(DbUserEntity userEntity, DbUserInfoEntity userInfo){
        ormAdapter.saveUser(userEntity, userInfo);
    }

    public void removeUserById(int id){
        ormAdapter.removeById(id);
    }
}
