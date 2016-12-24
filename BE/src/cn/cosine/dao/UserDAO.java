package cn.cosine.dao;

import java.util.List;

import cn.cosine.models.User;

public interface UserDAO {
    List<User> findAll();
    List<User> findById();
    List<User> findByName();
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
