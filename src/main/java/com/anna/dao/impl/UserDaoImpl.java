package com.anna.dao.impl;

import com.anna.connection.ConnectionManager;
import com.anna.dao.UserDao;
import com.anna.entity.User;
import org.springframework.util.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByLogin(String login) {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        User user = null;
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("SELECT * FROM account where LOGIN=?");
                pr.setString(1, login);
                ResultSet resultSet = pr.executeQuery();
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setSurname(resultSet.getString("SURNAME"));
                    user.setLogin(login);
                    user.setPassword(resultSet.getString("PASSWORD"));
                    return user;
                }
                pr.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public Boolean save(User user) {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("insert into account (NAME, SURNAME, LOGIN, PASSWORD) values (?, ?, ?, ?)");
                pr.setString(1, user.getName());
                pr.setString(2, user.getSurname());
                pr.setString(3, user.getLogin());
                pr.setString(4, DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
                pr.executeUpdate();
                pr.close();
                con.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
