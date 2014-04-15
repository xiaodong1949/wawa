<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>

<body>
	<div class="container">
		<form role="form" class="form-signin"
			action='${pageContext.request.contextPath }/login.do' method="post">

			<h2 class="form-signin-heading">
				<spring:message code="sys.button.login" />
			</h2>
			<input type="text" class="form-control" id="account" name="account"
				placeholder="<spring:message code="sys.navbar.accoremail" />"
				required autofocus> <input type="password"
				class="form-control" id="password" name="password"
				placeholder="<spring:message code="sys.navbar.password" />" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<spring:message code="sys.button.login" />
			</button>
			<button class="btn btn-lg btn-warning btn-block" type="submit">
				<spring:message code="sys.button.register" />
			</button>
		</form>
	</div>
</body>
</html>
