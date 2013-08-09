<div class="row">
  <div class="col-lg-12">
    <h2>Update User</h2>
    <form:form action="${pageContext.request.contextPath}/user/update"
      modelAttribute="userForm" class="form-horizontal">
      <div class="form-group">
        <form:label path="id" class="control-label">User Id</form:label>
        <div class="controls">
          ${f:h(userForm.id)}
          <form:input path="id" type="hidden" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="name" class="control-label">User Name</form:label>
        <div class="controls">
          ${f:h(userForm.name)}
          <form:input path="name" type="hidden" />
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
          <form:input path="birth" type="hidden" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="password" class="control-label">User Password</form:label>
        <div class="controls">
          ******
          <form:input path="password" type="hidden" />
        </div>
      </div>
      <div class="form-group">
        <form:label path="confirmPassword" class="control-label">User Password (Confirm)</form:label>
        <div class="controls">
          ******
          <form:input path="confirmPassword" type="hidden" />
        </div>
      </div>
      <div class="form-actions">
        <form:hidden path="id" />
        <form:hidden path="version" />
        <input type="submit" class="btn btn-primary" name="update"
          value="Update" /> <input type="submit" class="btn btn-default"
          name="redo" value="Back to Form" />
      </div>
    </form:form>
  </div>
</div>