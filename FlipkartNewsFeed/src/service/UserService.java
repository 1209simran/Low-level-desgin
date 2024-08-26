package service;

import model.User;
import repository.UserRespository;


public class UserService {

    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public void registerUser(String name){
        // check if user already exist, if not then register otherwise return saying user already exist
        if(userRespository.checkUserExist(name))
        {
            System.out.println("User "+name+" already exists");
            return;
        }
        User user = new User(name);
        userRespository.registerUser(user);
        System.out.println("User "+name+" added");
    }

    public void login(String name)
    {
        if(!userRespository.checkUserExist(name)) {
            System.out.println("User " + name + " doesn't exists");
            return;
        }
         userRespository.login(name);
        System.out.println("User " + name + " is logged in");
    }

    public void logout(String name)
    {
        boolean isLoggedOut = userRespository.logout(name);
        if(isLoggedOut)
            System.out.println("User "+ name+ " logged out");
        else{
            System.out.println("User "+name+" doesn't exists");
        }
    }

    public void follow(String userName, String followerName){
        if(!userRespository.checkUserExist(userName))
        {
            System.out.println("User "+userName+" doesn't exists");
            return;
        }
        if(!userRespository.isUserLoggedIn(userName))
        {
            System.out.println("User "+ userName + " is not logged in");
            return;
        }
        if(!userRespository.checkUserExist(followerName))
        {
            System.out.println("User "+followerName+" doesn't exists");
            return;
        }
        userRespository.follow(userName, followerName);
        System.out.println(userName + " started following "+ followerName);
    }
}
