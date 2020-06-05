package com.boushib.dao;

import com.boushib.beans.Offer;

import java.util.List;
import java.util.UUID;

public interface IOfferDao {
  List<Offer> getAllOffers();
  Offer getOfferById(UUID offerId);
  Offer getOfferBySlug(String offerSlug);
}
