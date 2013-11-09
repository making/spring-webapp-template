<div class="col-sm-12">
	<form:form action="${pageContext.request.contextPath}/user/create"
		modelAttribute="userForm" class="form-horizontal">
		<fieldset>
			<legend>New User</legend>
			<div class="form-group">
				<form:label path="name" class="col col-sm-2 control-label">User Name</form:label>
				<div class="col col-sm-10">
					${f:h(userForm.name)}
					<form:hidden path="name" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="email" class="col col-sm-2 control-label">E-mail</form:label>
				<div class="col col-sm-10">
					${f:h(userForm.email)}
					<form:hidden path="email" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="birth" class="col col-sm-2 control-label">User Birth</form:label>
				<div class="col col-sm-10">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${userForm.birth}" />
					<form:hidden path="birth" />
					<form:errors path="birth" cssClass="text-danger" />
					(* yyyy-MM-dd)
				</div>
			</div>
			<div class="form-group">
				<form:label path="password" class="col col-sm-2 control-label">User Password</form:label>
				<div class="col col-sm-10">
					******
					<form:hidden path="password" />
					<form:errors path="password" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="confirmPassword"
					class="col col-sm-2 control-label">User Password (confirm)</form:label>
				<div class="col col-sm-10">
					******
					<form:hidden path="confirmPassword" />
					<form:errors path="confirmPassword" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="col col-sm-10 col-sm-offset-2">
					<input type="submit" class="btn btn-primary" name="create"
						value="Create" /> <input type="submit" class="btn btn-default"
						name="redo" value="Back to Form" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>