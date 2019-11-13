package main.java.com.orm.secondormlib;

import java.util.HashSet;

public interface ISecondOrmCotext {

    HashSet<DbUserEntity> getUsers();
    HashSet<DbUserInfoEntity> getUsersInfo();
}
