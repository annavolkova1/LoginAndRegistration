package com.anna.dao;

import com.anna.entity.User;
import java.sql.SQLException;

public interface UserDao {
    User findByLogin(String login) throws SQLException;
    Boolean save(User user);
}
