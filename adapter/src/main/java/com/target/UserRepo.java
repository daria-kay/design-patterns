package com.target;

public interface UserRepo {
    int saveUser(String login, String userName, int roleId);
    boolean deleteUserById(int id);
    User findUserById(int id);
}
