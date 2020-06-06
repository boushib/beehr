package com.boushib.dao;

import com.boushib.beans.Application;
import com.boushib.beans.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ApplicationDao implements IApplicationDao {
  private DaoFactory daoFactory;

  ApplicationDao(DaoFactory daoFactory){
    this.daoFactory = daoFactory;
  }

  @Override
  public List<Application> getApplicationsForUser(UUID userId, String accountType) {
    List<Application> applications = new ArrayList<Application>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = daoFactory.getConnection();
      if ( accountType.equals("corporate") ){
        statement = connection.prepareStatement("SELECT * FROM applications WHERE employer_id = ? AND status = 'pending'");
      } else {
        statement = connection.prepareStatement("SELECT * FROM applications WHERE applicant_id = ?");
      }
      statement.setString(1, userId.toString());
      resultSet = statement.executeQuery();

      while(resultSet.next()){
        UUID id = UUID.fromString(resultSet.getString("id"));
        String title = resultSet.getString("title");
        String status = resultSet.getString("status");
        Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
        Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));
        UUID offer_id = UUID.fromString(resultSet.getString("offer_id"));
        UUID employer_id = UUID.fromString(resultSet.getString("employer_id"));
        UUID applicant_id = UUID.fromString(resultSet.getString("applicant_id"));

        Application application = new Application();

        application.setId(id);
        application.setTitle(title);
        application.setStatus(status);
        application.setCreatedAt(created_at);
        application.setUpdatedAt(updated_at);
        application.setOfferId(offer_id);
        application.setEmployerId(employer_id);
        application.setApplicantId(applicant_id);

        System.out.println(application.getTitle());

        applications.add(application);
      }

    } catch(Exception e){
      e.printStackTrace();
    }
    return applications;
  }

  @Override
  public void submitApplication(Application application) {
    try {
      Connection connection = daoFactory.getConnection();
      PreparedStatement statement = connection.prepareStatement("INSERT into applications (id, title, offer_id, employer_id, applicant_id) VALUES (?, ?, ?, ?, ?)");
      statement.setString(1, UUID.randomUUID().toString());
      statement.setString(2, application.getTitle());
      statement.setString(3, application.getOfferId().toString());
      statement.setString(4, application.getEmployerId().toString());
      statement.setString(5, application.getApplicantId().toString());
      statement.executeQuery();

    } catch(Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public void updateApplication(UUID applicationId, String status) {
    try {
      Connection connection = daoFactory.getConnection();
      PreparedStatement statement = connection.prepareStatement("UPDATE applications SET status = ? WHERE id = ? ;");
      statement.setString(1, status);
      statement.setString(2, applicationId.toString());
      statement.executeUpdate();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
