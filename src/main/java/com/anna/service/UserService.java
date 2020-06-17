package com.anna.service;

import com.anna.entity.User;

import java.sql.SQLException;

public interface UserService {
    String login(User user) throws SQLException;
    String registration(User user) throws SQLException;
}
