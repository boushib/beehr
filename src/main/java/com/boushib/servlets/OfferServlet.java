package com.boushib.servlets;

import com.boushib.beans.Offer;
import com.boushib.beans.User;
import com.boushib.dao.DaoFactory;
import com.boushib.dao.IOfferDao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class OfferServlet extends HttpServlet {
  private IOfferDao offerDao;

  public void init() throws ServletException {
    DaoFactory daoFactory = DaoFactory.getInstance();
    this.offerDao = daoFactory.getOfferDao();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    switch (action){
      case "create-offer":
        createOffer(request, response);
        break;
      case "populate_offer_to_update":
        populateOfferForUpdate(request, response);
        break;
      case "update-offer":
        updateOffer(request, response);
        break;
      case "delete-offer":
        deleteOffer(request, response);
        break;
      default:
        response.sendRedirect("login");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getRequestURI().substring(request.getContextPath().length() + 1);

    if (path.equals("new_offer")) {
      Object user = request.getSession().getAttribute("user");
      if (user == null) response.sendRedirect("login");
      this.getServletContext().getRequestDispatcher("new_offer.jsp").forward(request, response);
    }

    UUID offerId = UUID.fromString(request.getParameter("offer_id"));
    Offer offer = offerDao.getOfferById(offerId);

    System.out.println(offer.getTitle());

    request.setAttribute("offer", offer);

    if (path.equals("update_offer")) {
      Object user = request.getSession().getAttribute("user");
      if (user == null) response.sendRedirect("login");
      this.getServletContext().getRequestDispatcher("update_offer.jsp").forward(request, response);
    }

    this.getServletContext().getRequestDispatcher("offer.jsp").forward(request, response);
  }

  protected void createOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");

    UUID user_id = user != null ? user.getId() : null;

    Offer offer = new Offer();

    String type = request.getParameter("type");
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    offer.setType(type);
    offer.setTitle(title);
    System.out.println(offer.getTitle());
    offer.setDescription(description);

    offerDao.createOffer(offer, user_id);
    response.sendRedirect("my_offers");
    // this.getServletContext().getRequestDispatcher("my_offers.jsp").forward(request, response);
  }

  protected void updateOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Offer offer = new Offer();

    UUID offerId = UUID.fromString(request.getParameter("id"));
    String type = request.getParameter("type");
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    offer.setType(type);
    offer.setTitle(title);
    offer.setDescription(description);

    offerDao.updateOffer(offer, offerId);
    response.sendRedirect("my_offers");
  }

  protected void deleteOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UUID offerId = UUID.fromString(request.getParameter("offer_id"));
    offerDao.deleteOffer(offerId);
    response.sendRedirect("my_offers");
  }

  protected void populateOfferForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UUID offerId = UUID.fromString(request.getParameter("offer_id"));
    Offer offer = offerDao.getOfferById(offerId);
    request.setAttribute("offer", offer);
    this.getServletContext().getRequestDispatcher("update_offer.jsp").forward(request, response);
  }
}
