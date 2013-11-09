<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap.css" />
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap-theme.css" />
<style type="text/css">
body {
  padding-top: 60px;
  /* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<title>Not Found</title>
</head>
<body>
  <div class="container">
    <jsp:include page="layout/header.jsp" />
      <div class="col-sm-12">
        <p class="alert alert-danger">
          [<c:choose><c:when test="${not empty exceptionCode}">${f:h(exceptionCode)}</c:when><c:otherwise>${f:h(param.exceptionCode)}</c:otherwise></c:choose>]
          Your request is not found...<br /> <a
            href="${pageContext.request.contextPath}" class="btn btn-default">Go
            to TOP</a>
        </p>
      </div>
    </div>
</body>
</html>