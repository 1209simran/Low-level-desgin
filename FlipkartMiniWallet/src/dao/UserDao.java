package dao;

import model.User;

import java.util.HashMap;
import java.util.Objects;

public class UserDao {

    private HashMap<String, User> userMap;
    private static int id =1;

    public UserDao() {
        this.userMap = new HashMap<>();
    }

    public boolean checkUserExists(String userName) {
        if(userMap.containsKey(userName))
            return true;
        return false;
    }

    public void registerUser(String userName) {
        if(Objects.nonNull(userName)) {
            User user = new User();
            int userId = generateId();
            user.setId(userId);
            user.setName(userName);
            userMap.put(userName, user);
            System.out.println("User "+userName+ " is registered");
        }
    }

    private int generateId() {
        return id++;
    }
}
