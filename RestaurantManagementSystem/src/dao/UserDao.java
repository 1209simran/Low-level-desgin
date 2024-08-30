package dao;

import model.User;

import java.util.HashMap;

public class UserDao {
    private HashMap<Integer, User> users;

    public UserDao() {
        this.users = new HashMap<>();
    }

    public void addUser(int id, String name, boolean isAdmin){
        User user = new User(id, name, isAdmin);
        users.put(id, user);
        if(user.isAdmin())
            System.out.println("Added admin user with id - "+ user.getId());
        else
            System.out.println("Added user with id - "+ user.getId());
    }
}
