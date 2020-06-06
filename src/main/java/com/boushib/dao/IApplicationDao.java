package com.boushib.dao;

import com.boushib.beans.Application;

import java.util.List;
import java.util.UUID;

public interface IApplicationDao {
  List<Application> getApplicationsForUser(UUID userId, String accountType);
  void submitApplication(Application application);
  void updateApplication(UUID applicationId, String status);
}
