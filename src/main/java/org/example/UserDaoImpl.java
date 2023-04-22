package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private ArrayList<User> userList = new ArrayList<>();


    public UserDaoImpl() {
        //this.userList = new ArrayList<User>(List.of(new User("Petr"), new User("Ivan"), new User("Aleksey")));
        this.userList.add(new User("Petr"));
        this.userList.add(new User("Ivan"));
        this.userList.add(new User("Aleksey"));


    }

    @Override
    public User getUserByName(String userName) {
        if (userList.stream().anyMatch(o -> o.getName().equals(userName))) {
            //User userFound = userList.stream().filter(o -> o.getName().equals(userName)).findAny().get();
            //return userFound;
            return userList.stream().filter(o -> o.getName().equals(userName)).findAny().orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<User> findAllUsers () {
        return userList;
    }
}
