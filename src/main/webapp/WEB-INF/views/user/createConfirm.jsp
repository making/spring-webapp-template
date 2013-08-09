<div class="row">
  <div class="col-lg-12">
    <h2>New User</h2>
    <form:form action="${pageContext.request.contextPath}/user/create"
      modelAttribute="userForm" class="form-horizontal">
      <div class="form-group">
        <form:label path="name" class="control-label">User Name</form:label>
        <div class="controls">
          ${f:h(userForm.name)}
          <form:hidden path="name" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="email" class="control-label">E-mail</form:label>
        <div class="controls">
          ${f:h(userForm.email)}
          <form:hidden path="email" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="birth" class="control-label">User Birth</form:label>
        <div class="controls">
          <fmt:formatDate pattern="yyyy-MM-dd" value="${userForm.birth}"/>
          <form:hidden path="birth" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="password" class="control-label">User Password</form:label>
        <div class="controls">
          ******
          <form:hidden path="password" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="confirmPassword" class="control-label">User Password (Confirm)</form:label>
        <div class="controls">
          ******
          <form:hidden path="confirmPassword" />
        </div>
      </div>
      <div class="form-actions">
        <input type="submit" class="btn btn-primary" name="create"
          value="Create" /> <input type="submit" class="btn btn-default"
          name="redo" value="Back to Form" />
      </div>
    </form:form>
  </div>
</div>