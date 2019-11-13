package com.orm.firstormlib;


import com.orm.IDbEntity;

public interface IFirstOrm<TDbEntity extends IDbEntity> {
    void add(TDbEntity entity);
    TDbEntity read(int id);
    void delete(TDbEntity entity);
}
