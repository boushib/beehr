package com.boushib.beans;

import java.sql.Timestamp;
import java.util.UUID;

public class Application {
  private UUID id;
  private String title;
  private String status;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private UUID offerId;
  private UUID employerId;
  private UUID applicantId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UUID getOfferId() {
    return offerId;
  }

  public void setOfferId(UUID offerId) {
    this.offerId = offerId;
  }

  public UUID getEmployerId() {
    return employerId;
  }

  public void setEmployerId(UUID employerId) {
    this.employerId = employerId;
  }

  public UUID getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(UUID applicantId) {
    this.applicantId = applicantId;
  }
}
