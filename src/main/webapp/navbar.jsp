<nav>
  <div class="container">
    <div class="nav-brand">
      <a href="index.jsp">BeeHR</a>
    </div>
    <ul class="main-menu">
      <li><a href="offers">Offers</a></li>
      <c:if test="${ empty sessionScope.user }">
        <li><a href="login">Login</a></li>
      </c:if>
      <c:if test="${ !empty sessionScope.user }">
        <li><a href="my_offers">My Offers</a></li>
        <li><a href="profile">My Profile</a></li>
        <li><a href="logout">Logout</a></li>
      </c:if>
    </ul>
  </div>
</nav>