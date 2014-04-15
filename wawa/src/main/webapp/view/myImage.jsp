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
<link href="css/charisma-app.css" rel="stylesheet">
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
		<div class="jumbotron">
	        <h1>Marketing stuff!</h1>
	        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
	        <p> 
	        	<form class="form-inline" action="${pageContext.request.contextPath }/uploadMyResource.do?resourcetype=1" method="post" enctype="multipart/form-data">
					<input type="file" id="myPicFile" name="myPicFile">
					<div class="checkbox">
					    <label>
					      <input id="ispublic" type="checkbox"><spring:message code="sys.text.public" />
					    </label>
				    </div>
					<textarea class="form-control" rows="3" id="desc" name="desc"></textarea>
					<button type="submit" class="btn btn-default">
						<spring:message code="sys.button.upload" />
					</button>
				</form>
  			</p>
      	</div>
		<div class="row">
			<c:forEach var="resource" items="${imageList}">
			        <div class="col-lg-3">
				        <div class="thumbnail">
				          <img  src="${resource.resourcename}" data-src="${resource.resourcename}" >
				        </div>
			        </div>
		</c:forEach>		
		</div>
			

	</div>

	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery.colorbox-min.js"></script>
	
</body>
</html>
