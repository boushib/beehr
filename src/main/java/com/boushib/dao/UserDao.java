package com.boushib.dao;

import com.boushib.beans.User;

import java.sql.*;
import java.util.UUID;

public class UserDao implements IUserDao {
  private DaoFactory daoFactory;

  UserDao(DaoFactory daoFactory){
    this.daoFactory = daoFactory;
  }

  @Override
  public User login(String email, String password) {
    User user = null;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
      connection = daoFactory.getConnection();
      statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
      statement.setString(1, email);
      statement.setString(2, password);
      resultSet = statement.executeQuery();

      while(resultSet.next()){

        user = new User();

        UUID user_id = UUID.fromString(resultSet.getString("id"));
        String user_name = resultSet.getString("name");
        String user_email = resultSet.getString("email");
        String gender = resultSet.getString("gender");
        String account_type = resultSet.getString("account_type");
        Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));

        user.setId(user_id);
        user.setName(user_name);
        user.setEmail(user_email);
        user.setGender(gender);
        user.setAccountType(account_type);
        user.setCreatedAt(created_at);
      }
    } catch (Exception e){
      e.printStackTrace();
    }
    return user;
  }
}
