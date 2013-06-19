<div class="row">
  <div class="span12">
    <h2>New User</h2>
    <form:form action="${pageContext.request.contextPath}/user/create"
      modelAttribute="userForm" class="form-horizontal">
      <div class="control-group">
        <form:label path="name" class="control-label">User Name</form:label>
        <div class="controls">
          <form:input path="name" type="text" />
          <form:errors path="name" cssClass="text-error" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="email" class="control-label">E-mail</form:label>
        <div class="controls">
          <form:input path="email" type="text" />
          <form:errors path="email" cssClass="text-error" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="birth" class="control-label">User Birth</form:label>
        <div class="controls">
          <form:input path="birth" type="text" />
          <form:errors path="birth" cssClass="text-error" /> (* yyyy/MM/dd)
        </div>
      </div>
      <div class="control-group">
        <form:label path="password" class="control-label">User Password</form:label>
        <div class="controls">
          <form:input path="password" type="password" />
          <form:errors path="password" cssClass="text-error" />
        </div>
      </div>
      <div class="control-group">
        <form:label path="confirmPassword" class="control-label">User Password (Confirm)</form:label>
        <div class="controls">
          <form:input path="confirmPassword" type="password" />
          <form:errors path="confirmPassword" cssClass="text-error" />
        </div>
      </div>
      <div class="form-actions">
        <input type="submit" class="btn btn-primary" name="confirm"
          value="Confirm" /> <input type="submit" class="btn"
          name="redirectToList" value="Back to List" />
      </div>
    </form:form>
  </div>
</div>