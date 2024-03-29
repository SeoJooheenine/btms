<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 태그를 이용해 code속성에 프로퍼티 파일의 site.title 값을 표시  (무슨 말인지 잘 모르겠다.)-->
<title><spring:message code="site.title" text="Member Info" /></title>
</head>
<body>
	<a href="${contextPath }/interceptor/locale.do?locale=ko">한국어</a>
	<a href="${contextPath }/interceptor/locale.do?locale=en">ENGLISH</a>
	<h1><spring:message code="site.title" text="Member Info" /></h1>
	
	<p><spring:message code="site.name" text="no name" />
	   <spring:message code="name" text="no name" /></p>
	<p><spring:message code="site.job" text="no job" />
	   <spring:message code="job" text="no job" /></p>
	
	<input type="button" value="<spring:message code='btn.send' />" />
	<input type="button" value="<spring:message code='btn.cancel' />" />
	<input type="button" value="<spring:message code='btn.finish' />" />
</body>
</html>