package com.boushib.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.boushib.beans.*;
import com.boushib.dao.IOfferDao;
import com.boushib.dao.DaoFactory;

@WebServlet(name = "Offers")
public class Offers extends HttpServlet {

  private IOfferDao offerDao;

  public void init() throws ServletException {
    DaoFactory daoFactory = DaoFactory.getInstance();
    this.offerDao = daoFactory.getOfferDao();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // check offers or my_offers
    String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
    if (path.equals("offers")) getAllOffers(request, response);
    if (path.equals("my_offers")) getOffersForUser(request, response);
  }

  protected void getAllOffers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Offer> offers = offerDao.getAllOffers();
    HttpSession session = request.getSession();
    session.setAttribute("offers", offers);
    request.setAttribute("offers", offers);
    this.getServletContext().getRequestDispatcher("offers.jsp").forward(request, response);
  }
  protected void getOffersForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");
    if( user == null ) response.sendRedirect("login");

    UUID user_id = user.getId();

    List<Offer> offers = offerDao.getOffersForUser(user_id);
    HttpSession session = request.getSession();
    session.setAttribute("my_offers", offers);
    request.setAttribute("my_offers", offers);
    this.getServletContext().getRequestDispatcher("my_offers.jsp").forward(request, response);
  }
}
