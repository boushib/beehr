<%@include file="header.jsp"%>
<main class="offers">
  <div class="container">
    <h1>
      All Offers
      <a href="new_car.do"><span class="material-icons add">add_circle</span></a>
    </h1>
    <table>
      <thead>
      <tr>
        <th>Type</th>
        <th>Title</th>
        <th>Posted at</th>
        <td></td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${offers}" var="offer">
        <tr class="pointer">
          <td><c:out value="${ offer.type }" /></td>
          <td><c:out value="${ offer.title }" /></td>
          <td><fmt:formatDate value="${ offer.createdAt }" pattern="MM/dd/yyyy" /></td>
          <td class="actions">
            <a href="offer?id=${offer.id}"><span class="material-icons view">visibility</span></a>
            <form action="update_car_p.do" method="post">
              <input type="hidden" name="car_id" value="${offer.id}">
              <button><span class="material-icons edit">create</span></button>
            </form>
            <form action="delete.do" method="post">
              <input type="hidden" name="car_id" value="${offer.id}">
              <button><span class="material-icons delete">delete</span></button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</main>
<%@include file="footer.jsp"%>
