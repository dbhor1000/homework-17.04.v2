package org.example;

import java.util.ArrayList;

public interface UserDao {

    User getUserByName(String userName);
    ArrayList<User> findAllUsers ();

}
