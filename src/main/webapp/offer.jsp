<%@include file="header.jsp"%>
<main class="offer center-content">
  <div class="container">
    <c:if test="${ !empty sessionScope.offer }">
      <div class="card">
        <h2 class="title">${offer.title}</h2>
        <div class="type">${offer.type}</div>
        <div class="date">Posted at: <fmt:formatDate value="${ offer.createdAt }" pattern="MM/dd/yyyy " /></div>
        <div class="description">${offer.description}</div>
        <button class="btn">Apply</button>
      </div>
    </c:if>
  </div>
</main>
<%@include file="footer.jsp"%>