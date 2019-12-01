package com.adapter;

import com.darakay.patterns.client.IOrmAdapter;
import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;
import com.orm.secondormlib.ISecondOrm;
import com.darakay.patterns.client.User;

import java.util.stream.Collectors;

public class SecondOrmAdapter implements IOrmAdapter {
    private ISecondOrm secondOrm;

    public SecondOrmAdapter(ISecondOrm secondOrm) {
        this.secondOrm = secondOrm;
    }

    @Override
    public User getUserById(int id) {
        DbUserEntity userEntity = secondOrm.getContext()
                .getUsers()
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst().get();

        DbUserInfoEntity userInfo = secondOrm.getContext()
                .getUsersInfo()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();

        return User.builder()
                .userEntity(userEntity)
                .userInfo(userInfo)
                .build();
    }

    @Override
    public void saveUser(DbUserEntity userEntity, DbUserInfoEntity userInfo) {
        secondOrm.getContext().getUsers().add(userEntity);
        secondOrm.getContext().getUsersInfo().add(userInfo);
    }

    @Override
    public void removeById(int id) {
        secondOrm.getContext().getUsers().stream().collect(Collectors.toMap(DbUserEntity::getId, user -> user))
                .remove(id);
        secondOrm.getContext().getUsersInfo().stream().collect(Collectors.toMap(DbUserInfoEntity::getId, info -> info))
                .remove(id);
    }
}
