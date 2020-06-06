<%@include file="header.jsp"%>
<main class="offer center-content">
  <div class="container">
    <div class="card">
      <h2 class="title">${offer.title}</h2>
      <div class="type">${offer.type}</div>
      <div class="date">Posted at: <fmt:formatDate value="${ offer.createdAt }" pattern="MM/dd/yyyy " /></div>
      <div class="description">${offer.description}</div>
      <c:if test="${ sessionScope.user.accountType.equals('normal') }">
        <form action="applications" method="post">
          <input type="hidden" name="action" value="submit-application">
          <input type="hidden" name="offer_id" value="${offer.id}">
          <input type="hidden" name="employer_id" value="${offer.userId}">
          <input type="hidden" name="title" value="${offer.title}">
          <button class="btn">Apply</button>
        </form>
      </c:if>
    </div>
  </div>
</main>
<%@include file="footer.jsp"%>