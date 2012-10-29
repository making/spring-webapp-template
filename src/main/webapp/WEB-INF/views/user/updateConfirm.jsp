<div class="row">
  <div class="span12">
    <h2>Update User</h2>
    <form:form action="${pageContext.request.contextPath}/user/update"
      modelAttribute="userUpdateForm" class="form-horizontal">
      <div class="control-group">
        <form:label path="id" class="control-label">User Id</form:label>
        <div class="controls">
          ${f:h(userUpdateForm.id)}
          <form:input path="id" type="hidden" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="name" class="control-label">User Name</form:label>
        <div class="controls">
          ${f:h(userUpdateForm.name)}
          <form:input path="name" type="hidden" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="email" class="control-label">E-mail</form:label>
        <div class="controls">
          ${f:h(userUpdateForm.email)}
          <form:hidden path="email" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="birth" class="control-label">User Birth</form:label>
        <div class="controls">
          ${f:h(userUpdateForm.birth)}
          <form:input path="birth" type="hidden" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="password" class="control-label">User Password</form:label>
        <div class="controls">
          ******
          <form:input path="password" type="hidden" />
        </div>
      </div>
      <div class="control-group">
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
          value="Update" /> <input type="submit" class="btn"
          name="form" value="Back to Form" />
      </div>
    </form:form>
  </div>
</div>