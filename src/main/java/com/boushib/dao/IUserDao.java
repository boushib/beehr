package com.boushib.dao;

import com.boushib.beans.User;

public interface IUserDao {
  User login(String email, String password);
}
