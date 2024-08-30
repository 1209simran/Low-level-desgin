package service;

import dao.UserDao;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String userName){
        if(userDao.checkUserExists(userName))
        {
            System.out.println("User already exists");
            return;
        }
        userDao.registerUser(userName);
    }
}
