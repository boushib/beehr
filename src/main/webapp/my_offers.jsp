<%@include file="header.jsp"%>
<main class="offers">
  <div class="container">
    <h1>
      My Offers
      <a href="new_offer"><span class="material-icons add">add_circle</span></a>
    </h1>
    <table class="offers-table">
      <thead>
      <tr>
        <th>Type</th>
        <th>Title</th>
        <th>Posted at</th>
        <td></td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${my_offers}" var="offer">
        <tr class="pointer" data-link="offer?offer_id=${offer.id}">
          <td><c:out value="${ offer.type }" /></td>
          <td><c:out value="${ offer.title }" /></td>
          <td><fmt:formatDate value="${ offer.createdAt }" pattern="MM/dd/yyyy" /></td>
          <td class="actions">
            <form action="offer" method="post">
              <input type="hidden" name="action" value="populate_offer_to_update">
              <input type="hidden" name="offer_id" value="${offer.id}">
              <button class="pointer"><span class="material-icons edit">create</span></button>
            </form>
            <form action="offer" method="post">
              <input type="hidden" name="action" value="delete-offer">
              <input type="hidden" name="offer_id" value="${offer.id}">
              <button class="pointer"><span class="material-icons delete">delete</span></button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</main>
<%@include file="footer.jsp"%>
