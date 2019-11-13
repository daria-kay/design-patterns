package main.java.com.orm.firstormlib;

import main.java.com.orm.IDbEntity;

public interface IFirstOrm<TDbEntity extends IDbEntity> {
    void add(TDbEntity entity);
    TDbEntity read(int id);
    void delete(TDbEntity entity);
}
