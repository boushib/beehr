<%@include file="header.jsp"%>
<main class="offers">
  <div class="container">
    <h1>My Applications</h1>
    <table class="offers-table">
      <thead>
      <tr>
        <th>Title</th>
        <th>Date</th>
        <th>Applicant</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${applications}" var="application">
        <tr>
          <td><c:out value="${ application.title }" /></td>
          <td><fmt:formatDate value="${ application.createdAt }" pattern="MM/dd/yyyy" /></td>
          <td><c:out value="${ application.applicantId }" /></td>
          <td>
          <td class="actions">
            <form action="applications" method="post">
              <input type="hidden" name="action" value="approve-application">
              <input type="hidden" name="application_id" value="${application.id}">
              <button class="pointer"><span class="material-icons success">check_circle</span></button>
            </form>
            <form action="applications" method="post">
              <input type="hidden" name="action" value="reject-application">
              <input type="hidden" name="application_id" value="${application.id}">
              <button class="pointer"><span class="material-icons delete">cancel</span></button>
            </form>
          </td>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</main>
<%@include file="footer.jsp"%>