package com.boushib.servlets;

import com.boushib.beans.Application;
import com.boushib.beans.Offer;
import com.boushib.beans.User;
import com.boushib.dao.DaoFactory;
import com.boushib.dao.IApplicationDao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class ApplicationServlet extends HttpServlet {
  private IApplicationDao applicationDao;

  public void init() {
    DaoFactory daoFactory = DaoFactory.getInstance();
    this.applicationDao = daoFactory.getApplicationDao();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    switch (action){
      case "submit-application":
        submitApplication(request, response);
        break;
      case "approve-application":
        updateApplication(request, response, action);
        break;
      case "reject-application":
        updateApplication(request, response, action);
      default:
        response.sendRedirect("login");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");
    UUID user_id = user != null ? user.getId() : null;
    String accountType = user != null ? user.getAccountType() : null;
    if( user_id == null ) response.sendRedirect("login");
    request.setAttribute("applications", applicationDao.getApplicationsForUser(user_id, accountType));
    String redirectFile = accountType.equals("corporate") ? "employer-applications.jsp" : "applications.jsp";
    this.getServletContext().getRequestDispatcher(redirectFile).forward(request, response);
  }

  protected void submitApplication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("user");
    UUID user_id = user != null ? user.getId() : null;

    Application application = new Application();

    String title = request.getParameter("title");
    UUID offer_id = UUID.fromString(request.getParameter("offer_id"));
    UUID employer_id = UUID.fromString(request.getParameter("employer_id"));

    application.setTitle(title);
    application.setOfferId(offer_id);
    application.setEmployerId(employer_id);
    application.setApplicantId(user_id);

    applicationDao.submitApplication(application);
    response.sendRedirect("applications");
  }

  protected void updateApplication(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
    UUID id = UUID.fromString(request.getParameter("application_id"));
    String status = action.equals("approve-application") ? "approved" : "rejected";
    applicationDao.updateApplication(id, status);
    response.sendRedirect("applications");
  }
}
