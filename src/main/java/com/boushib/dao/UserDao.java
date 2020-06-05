package com.boushib.dao;

import com.boushib.beans.User;

public class UserDao implements IUserDao {
  private DaoFactory daoFactory;

  UserDao(DaoFactory daoFactory){
    this.daoFactory = daoFactory;
  }

  @Override
  public User login(String email, String password) {
    return null;
  }
}
