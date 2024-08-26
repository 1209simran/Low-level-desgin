package repository;

import model.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class UserRespository {

    private static UserRespository userRespository;
    private HashMap<String, User> users;

    public UserRespository() {
        this.users = new HashMap<>();
    }

    public static UserRespository getInstance() {
        if (userRespository == null)
            userRespository = new UserRespository();
        return userRespository;
    }

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public boolean checkUserExist(String name) {
        if (users.containsKey(name))
            return true;
        return false;
    }

    public boolean logout(String name) {
        if (checkUserExist(name)) {
            User user = users.get(name);
            user.setLastActiveAt(LocalDateTime.now());
            user.setActive(false);
            users.put(name, user);
            return true;
        }
        return false;
    }

    public void follow(String userName, String followerName) {
        User curUser = users.get(userName);
        User followerUser = users.get(followerName);
        curUser.addFollowers(followerName);
        followerUser.addFollowing(userName);
        users.put(userName, curUser);
        users.put(followerName, followerUser);
    }

    public boolean isUserLoggedIn(String userName) {
        User user = users.get(userName);
        return user.isActive();
    }

    public void login(String name) {
        User user = users.get(name);
        user.setActive(true);
        users.put(name, user);
    }

    public List<String> getFollowedUser(String name) {
        List<String> followdUser = users.get(name).getFollowers();
        return followdUser;
    }
}
