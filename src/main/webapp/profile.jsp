<%@include file="header.jsp"%>
<main class="offer center-content">
  <div class="container">
    <h2>Profile</h2>
    <c:if test="${ !empty sessionScope.user }">
      <div class="card">
        User Data
      </div>
    </c:if>
  </div>
</main>
<%@include file="footer.jsp"%>