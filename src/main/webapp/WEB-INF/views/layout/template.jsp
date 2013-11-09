<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
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
.my-inline.form-inline input[type="text"],
.my-inline.form-inline input[type="password"] {
  width: 240px;
}
.my-horizontal.form-horizontal input[type="text"],
.my-horizontal.form-horizontal input[type="password"] {
  width: 360px;
}
</style>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    
</script>
<c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="projectName" /></title>
<tiles:insertAttribute name="header" />
</head>
<body>
    <div class="container">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <hr>
        <div class="row">
            <div class="col-lg-12">
                <p style="text-align: center; background: #e5eCf9;">Copyright
                    &copy; 2013 projectName</p>
            </div>
        </div>
    </div>
</body>
</html>