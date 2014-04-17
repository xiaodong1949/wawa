<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/colorbox.css" rel="stylesheet" />
<link href="css/flat-ui.css" rel="stylesheet" />
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div class="container">
		<!-- nav start -->
		<%@include file="navbar.jsp"%>
		<!-- nav end -->
		<!-- carousel start  -->
		<div id="carousel-example-generic" class=" carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class=" carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="http://placehold.it/1140x500&text=smart" alt="First slide">
				</div>
				<div class="item">
					<img src="http://placehold.it/1140x500&text=Second slide" alt="Second slide">
					<div class="container"></div>
				</div>
				<div class="item">
					<img src="http://placehold.it/1140x500&text:Third slide" alt="Third slide">
				</div>
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
		<!-- carousel end -->
		<!-- image start-->
		<div class="row">
			<h3>Gallery</h3>
		</div>
		<div class="row">
			<c:forEach var="resource" items="${imageList}">
				<div class="col-lg-3">
					<div class="thumbnail">
						<img src="${resource.resourcename}" width="300" height="300" data-src="${resource.resourcename}">
						<p>${resource.description}</p>
						<a href="${pageContext.request.contextPath}/praise.do?id=${resource.id}"><p>
								<i class="glyphicon glyphicon-thumbs-up"></i></a>:${resource.praise}
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- image end -->
		<!-- video start -->
		<div class="row">
			<h3>video</h3>
		</div>
		<div class="row">
			<div class="col-lg-3">
				<video width="320" height="240" controls="controls">
					<source src="${pageContext.request.contextPath}/view/a.ogg" type="video/ogg">
					<source src="a.mp4" type="video/mp4">
					Your browser does not support the video tag.
				</video>
			</div>
		</div>
		<!-- video end -->
	</div>
	<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="loginlabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="loginlabel">
						<spring:message code="sys.navbar.login" />
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" action='${pageContext.request.contextPath }/login.do' method="post">
						<div class="form-group">
							<label for="account"><spring:message code="sys.navbar.accoremail" /></label> <input type="text" class="form-control" id="account"
								name="account" placeholder="<spring:message code="sys.navbar.accoremail" />">
						</div>
						<div class="form-group">
							<label for="password"><spring:message code="sys.navbar.password" /></label> <input type="password" class="form-control"
								id="password" name="password" placeholder="<spring:message code="sys.navbar.password" />">
						</div>
						<button type="submit" class="btn btn-default">
							<spring:message code="sys.button.login" />
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="registerlabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="registerlabel">
						<spring:message code="sys.navbar.register" />
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" action='${pageContext.request.contextPath }/register.do' method="post">
						<div class="form-group">
							<label for="account"><spring:message code="sys.navbar.account" /></label> <input type="text" class="form-control" id="account"
								name="account" value="" placeholder="<spring:message code="sys.navbar.account" />" onblur="alert('aaa')">
						</div>
						<div class="form-group">
							<label for="password"><spring:message code="sys.navbar.password1" /></label> <input type="password" class="form-control"
								id="password" name="password" value="" placeholder="<spring:message code="sys.navbar.password" />">
						</div>
						<div class="form-group">
							<label for="password1"><spring:message code="sys.navbar.password1" /></label> <input type="password" class="form-control"
								id="password1" name="password1" value="" placeholder="<spring:message code="sys.navbar.password1" />">
						</div>
						<div class="form-group">
							<label for="email"><spring:message code="sys.navbar.email" /></label> <input type="text" class="form-control" id="email"
								name="email" value="" placeholder="<spring:message code="sys.navbar.email" />">
						</div>
						<button type="submit" class="btn btn-default">
							<spring:message code="sys.button.login" />
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/video.js"></script>
</body>
</html>
