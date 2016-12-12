<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>用户信息</title>
</head>
<body data-role="page">
	<div><li>user:${user.name}</li><li>password:${user.password}</li></div>
</body>
</html>

