<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <!-- IE=edge告诉IE使用最新的引擎渲染网页，chrome=1则可以激活Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- device-width宽度设置为设备宽度，initial-scale=1 页面正常显示无缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>考拉的博客</title>
    <jsp:include page="/WEB-INF/views/common/base-import.jsp"/>
    <jsp:include page="/WEB-INF/views/common/bootstrap-improt.jsp"/>
</head>
<body>
<c:url value="${basePath}" var="url"/>
<spring:url value="${basePath}" htmlEscape="true" var="springUrl" />
Spring URL: ${springUrl} at ${time}
<br>
JSTL URL: ${url}
<br>
Message: ${message}
</body>

</html>