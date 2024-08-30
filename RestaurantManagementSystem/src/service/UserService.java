package service;

import dao.UserDao;
import model.User;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(int id, String name, boolean isAdmin){
        userDao.addUser(id, name, isAdmin);
    }
}
