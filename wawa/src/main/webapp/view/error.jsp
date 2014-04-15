<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="/WEB-INF/spring.tld"%>
<html>
<head><title>Exception!</title></head>
<body>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<H2><spring:message code='sys.error.name' /></label><%= e.getClass().getSimpleName()%></H2>
<hr />
<P><spring:message code='sys.error.description' /></label></P>
<%= e.getMessage()%>
<P><spring:message code='sys.error.info' /></label></P>
<% e.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>