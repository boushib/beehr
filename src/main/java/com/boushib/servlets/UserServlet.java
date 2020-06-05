package com.boushib.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.boushib.beans.*;
import com.boushib.dao.DaoFactory;
import com.boushib.dao.IUserDao;

@WebServlet(name = "User")
public class UserServlet extends HttpServlet {

  private IUserDao userDao;

  public void init() throws ServletException {
    DaoFactory daoFactory = DaoFactory.getInstance();
    this.userDao = daoFactory.getUserDao();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    login(request, response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
    if (path.equals("login")) this.getServletContext().getRequestDispatcher("login.jsp").forward(request, response);
    else checkUserAuthentication(request, response);
  }

  protected void checkUserAuthentication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Object user_session = request.getSession().getAttribute("user");

    if( user_session == null ) response.sendRedirect("login");
    else {
      String path = request.getRequestURI().substring(request.getContextPath().length() + 1);
      String redirectPath = path.equals("profile") ? "profile.jsp" : "index.jsp";
      this.getServletContext().getRequestDispatcher(redirectPath).forward(request, response);
    }
  }

  protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    User user = userDao.login(email, password);
    if( user == null ) {
      response.sendRedirect("login");
    } else {
      HttpSession session = request.getSession();
      session.setAttribute("user", user);
      response.sendRedirect("profile");
    }
  }

  protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.removeAttribute("user");
    response.sendRedirect("login");
  }
}
