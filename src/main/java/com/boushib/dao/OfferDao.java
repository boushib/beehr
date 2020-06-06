package com.boushib.dao;

import com.boushib.beans.Offer;
import com.boushib.beans.User;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OfferDao implements IOfferDao {
  private DaoFactory daoFactory;

  OfferDao(DaoFactory daoFactory){
    this.daoFactory = daoFactory;
  }

  @Override
  public List<Offer> getAllOffers() {
    List<Offer> offers = new ArrayList<Offer>();

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      connection = daoFactory.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * from offers;");

      while(resultSet.next()){
        UUID id = UUID.fromString(resultSet.getString("id"));
        String type = resultSet.getString("type");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
        Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));

        Offer offer = new Offer();

        offer.setId(id);
        offer.setType(type);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setCreatedAt(created_at);
        offer.setUpdatedAt(updated_at);

        offers.add(offer);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    return offers;
  }

  @Override
  public List<Offer> getOffersForUser(UUID userId) {
    List<Offer> offers = new ArrayList<Offer>();

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = daoFactory.getConnection();
      statement = connection.prepareStatement("SELECT * from offers WHERE user_id = ?;");
      statement.setString(1, userId.toString());
      resultSet = statement.executeQuery();

      while(resultSet.next()){
        UUID id = UUID.fromString(resultSet.getString("id"));
        String type = resultSet.getString("type");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
        Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));
        UUID user_id = UUID.fromString(resultSet.getString("user_id"));

        Offer offer = new Offer();

        offer.setId(id);
        offer.setType(type);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setCreatedAt(created_at);
        offer.setUpdatedAt(updated_at);
        offer.setUserId(user_id);

        offers.add(offer);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    return offers;
  }

  @Override
  public void createOffer(Offer user_offer, UUID user_id) {
    Offer offer = null;
    Connection connection = null;
    PreparedStatement statement = null;
      try {
        connection = daoFactory.getConnection();
        statement = connection.prepareStatement("INSERT INTO offers (id, type, title, description, user_id) VALUES (?, ?, ?, ?, ?);");
        statement.setString(1, UUID.randomUUID().toString());
        statement.setString(2, user_offer.getType());
        statement.setString(3, user_offer.getTitle());
        statement.setString(4, user_offer.getDescription());
        statement.setString(5, user_id.toString());

        statement.executeUpdate();
      } catch (Exception e){
        e.printStackTrace();
      }
  }

  @Override
  public void updateOffer(Offer offer, UUID offerId) {
      try {
        Connection connection = daoFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE offers SET type = ?, title = ?, description = ? WHERE id = ? ;");
        statement.setString(1, offer.getType());
        statement.setString(2, offer.getTitle());
        statement.setString(3, offer.getDescription());
        statement.setString(4, offerId.toString());
        statement.executeUpdate();
      } catch (Exception e){
        e.printStackTrace();
      }
  }

  @Override
  public void deleteOffer(UUID offerId) {
    Connection connection = null;
    PreparedStatement statement = null;
      try {
        connection = daoFactory.getConnection();
        statement = connection.prepareStatement("DELETE FROM offers WHERE id = ?;");
        statement.setString(1, offerId.toString());
        statement.executeUpdate();
      } catch (Exception e){
        e.printStackTrace();
      }
  }

  @Override
  public Offer getOfferById(UUID offerId) {
    List<Offer> offers = new ArrayList<Offer>();

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = daoFactory.getConnection();
      statement = connection.prepareStatement("SELECT * from offers WHERE id = ?;");
      statement.setString(1, offerId.toString());
      resultSet = statement.executeQuery();

      while(resultSet.next()){
        UUID id = UUID.fromString(resultSet.getString("id"));
        String type = resultSet.getString("type");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
        Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));
        UUID user_id = UUID.fromString(resultSet.getString("user_id"));

        Offer offer = new Offer();

        offer.setId(id);
        offer.setType(type);
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setCreatedAt(created_at);
        offer.setUpdatedAt(updated_at);
        offer.setUserId(user_id);

        offers.add(offer);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    return offers.get(0);
  }

  @Override
  public Offer getOfferBySlug(String offerSlug) {
    return null;
  }
}
