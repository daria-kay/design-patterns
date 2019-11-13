package com.adapter;

import com.orm.firstormlib.IFirstOrm;
import com.orm.secondormlib.DbUserEntity;
import com.orm.secondormlib.DbUserInfoEntity;
import com.orm.secondormlib.ISecondOrm;
import com.target.Role;
import com.target.User;
import com.target.UserRepo;

public class UserRepoAdapter implements UserRepo {
    private final IFirstOrm<Role> roles;
    private final IFirstOrm<User> users;
    private final ISecondOrm usersInfos;

    public UserRepoAdapter(IFirstOrm<Role> roles, IFirstOrm<User> users, ISecondOrm usersInfos) {
        this.roles = roles;
        this.users = users;
        this.usersInfos = usersInfos;
    }

    @Override
    public int saveUser(String login, String userName, int roleId) {
        DbUserEntity userEntity = usersInfos.getContext().getUsers().stream()
                .filter(usr -> usr.getLogin().equals(login))
                .findFirst()
                .get();
        DbUserInfoEntity infoEntity = usersInfos.getContext().getUsersInfo().stream()
                .filter(info -> info.getName().equals(userName))
                .findFirst()
                .get();

        Role userRole = roles.read(roleId);
        User user = new User(userEntity.getId(),
                userEntity.getLogin(),
                infoEntity.getName(), infoEntity.getBirthDate(), userRole);
        users.add(user);
        return user.getId();
    }

    @Override
    public boolean deleteUserById(int id) {
        User user = users.read(id);
        roles.delete(user.getRole());
        users.delete(user);
        return true;
    }

    @Override
    public User findUserById(int id) {
        return users.read(id);
    }
}
