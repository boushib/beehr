<%@include file="header.jsp"%>
<main class="login center-content">
  <div class="container">
    <div class="form-box">
      <h2>Login</h2>
      <form action="login" method="post">
        <div class="form-control">
          <label for="email">Email</label>
          <input type="email" name="email" id="email" placeholder="Enter your email">
        </div>
        <div class="form-control">
          <label for="password">Password</label>
          <input type="password" name="password" id="password" placeholder="Enter your password">
        </div>
        <button class="btn">Login</button>
      </form>
    </div>
  </div>
</main>
<%@include file="footer.jsp"%>