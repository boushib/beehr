package com.boushib.servlets;

import com.boushib.beans.Offer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class OfferServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String offerId = request.getParameter("id");

    List<Offer> offers = (List<Offer>) request.getSession().getAttribute("offers");
    List<Offer> filtered_offers = offers.stream().filter(offer -> offer.getId().toString().equals(offerId)).collect(Collectors.toList());

    Offer offer = null;
    if(!filtered_offers.isEmpty()) offer = filtered_offers.get(0);
    HttpSession session = request.getSession();
    session.setAttribute("offer", offer);
    System.out.println();
    this.getServletContext().getRequestDispatcher("offer.jsp").forward(request, response);
  }
}
