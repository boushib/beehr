<%@include file="header.jsp"%>
<main class="profile center-content">
  <div class="container">
    <c:if test="${ !empty sessionScope.user }">
      <div class="card">
        <h2>Profile</h2>
        <div class="name">Name: ${sessionScope.user.name}</div>
        <div class="email">Email: ${sessionScope.user.email}</div>
        <div class="gender">Gender: ${sessionScope.user.gender}</div>
        <div class="account-type">Account type: ${sessionScope.user.accountType}</div>
        <div class="registration-date">Member since: ${sessionScope.user.createdAt}</div>
      </div>
    </c:if>
  </div>
</main>
<%@include file="footer.jsp"%>