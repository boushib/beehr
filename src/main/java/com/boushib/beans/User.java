package com.boushib.beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  private String email;
  private String password;
  private String gender;
  private String accountType;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  public User() {
  }

  public User(UUID id, String name, String email, String password, String gender, String accountType, Timestamp createdAt, Timestamp updatedAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.accountType = accountType;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Timestamp getCreatedAt(){
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt(){
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
