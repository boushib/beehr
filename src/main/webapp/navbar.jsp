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
        <c:if test="${ sessionScope.user.accountType.equals('corporate') }">
          <li><a href="my_offers">My Offers</a></li>
        </c:if>
        <c:if test="${ sessionScope.user.accountType.equals('normal') }">
          <li><a href="applications">My Applications</a></li>
        </c:if>
        <c:if test="${ sessionScope.user.accountType.equals('corporate') }">
          <li><a href="applications">My Offers Applications</a></li>
        </c:if>
        <li><a href="profile">My Profile</a></li>
        <li><a href="logout">Logout</a></li>
      </c:if>
    </ul>
  </div>
</nav>