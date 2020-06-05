<%@include file="header.jsp"%>
<main class="new-offer center-content">
  <div class="container">
    <div class="form-box">
      <h2>Update offer</h2>
      <form action="offer" method="post">
        <input type="hidden" name="action" value="update-offer">
        <input type="hidden" name="id" value="${offer.id}">
        <div class="form-control">
          <label for="type">Offer type</label>
          <select name="type" id="type">
            <option value="job" ${offer.type == 'job' ? 'selected' : ''}>Job</option>
            <option value="internship" ${offer.type == 'internship' ? 'selected' : ''}>Internship</option>
          </select>
        </div>
        <div class="form-control">
          <label for="title">Offer title</label>
          <input type="text" name="title" id="title" placeholder="Enter offer title" value="${offer.title}">
        </div>
        <div class="form-control">
          <label for="description">Offer description</label>
          <input type="text" name="description" id="description" placeholder="Enter offer description" value="${offer.description}">
        </div>
        <button class="btn">Submit</button>
      </form>
    </div>
  </div>
</main>
<%@include file="footer.jsp"%>