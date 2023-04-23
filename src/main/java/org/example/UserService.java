package org.example;

public class UserService {

    final private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(String userName) {
        if(userDao.getUserByName(userName) != null) {
            return true;
        } else {
            return false;
        }
    }
}
