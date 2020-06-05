package com.boushib.dao;

import com.boushib.beans.Offer;

import java.util.List;
import java.util.UUID;

public interface IOfferDao {
  List<Offer> getAllOffers();
  List<Offer> getOffersForUser(UUID userId);
  void createOffer(Offer offer, UUID userId);
  void updateOffer(Offer offer, UUID userId);
  void deleteOffer(UUID offerId);
  Offer getOfferById(UUID offerId);
  Offer getOfferBySlug(String offerSlug);
}
