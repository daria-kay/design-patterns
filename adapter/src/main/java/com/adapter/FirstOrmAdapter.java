package com.adapter;

import com.darakay.patterns.client.IOrmAdapter;
import com.orm.firstormlib.IFirstOrm;
import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;
import com.darakay.patterns.client.User;

public class FirstOrmAdapter implements IOrmAdapter {

    private IFirstOrm<DbUserEntity> userEntityRepo;
    private IFirstOrm<DbUserInfoEntity> usersInfoEntityRepo;

    @Override
    public User getUserById(int id) {
        return User.builder()
                .userEntity(userEntityRepo.read(id))
                .userInfo(usersInfoEntityRepo.read(id))
                .build();
    }

    @Override
    public void saveUser(DbUserEntity userEntity, DbUserInfoEntity userInfo) {
        userEntityRepo.add(userEntity);
        usersInfoEntityRepo.add(userInfo);
    }

    @Override
    public void removeById(int id) {
        DbUserEntity userEntity = userEntityRepo.read(id);
        DbUserInfoEntity userInfo = usersInfoEntityRepo.read(id);
        userEntityRepo.delete(userEntity);
        usersInfoEntityRepo.delete(userInfo);
    }
}
