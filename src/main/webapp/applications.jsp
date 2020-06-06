<%@include file="header.jsp"%>
<main class="offers">
  <div class="container">
    <h1>My Applications</h1>
    <table class="offers-table">
      <thead>
      <tr>
        <th>Title</th>
        <th>Applied at</th>
        <th>Status</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${applications}" var="application">
        <tr class="pointer" data-link="application?application_id=${application.id}">
          <td><c:out value="${ application.title }" /></td>
          <td><fmt:formatDate value="${ application.createdAt }" pattern="MM/dd/yyyy" /></td>
          <td><span class="status ${ application.status }"></span> <c:out value="${ application.status }" /></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</main>
<%@include file="footer.jsp"%>