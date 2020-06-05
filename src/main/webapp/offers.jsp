<%@include file="header.jsp"%>
<main class="offers">
  <div class="container">
    <h1>
      All Offers
      <a href="new_car.do"><span class="material-icons add">add_circle</span></a>
    </h1>
    <table class="offers-table">
      <thead>
      <tr>
        <th>Type</th>
        <th>Title</th>
        <th>Posted at</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${offers}" var="offer">
        <tr class="pointer" data-link="offer?id=${offer.id}">
          <td><c:out value="${ offer.type }" /></td>
          <td><c:out value="${ offer.title }" /></td>
          <td><fmt:formatDate value="${ offer.createdAt }" pattern="MM/dd/yyyy" /></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</main>
<%@include file="footer.jsp"%>
