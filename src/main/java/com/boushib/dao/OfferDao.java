package com.boushib.dao;

import com.boushib.beans.Offer;

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
  public Offer getOfferById(UUID offerId) {
    return null;
  }

  @Override
  public Offer getOfferBySlug(String offerSlug) {
    return null;
  }
}
