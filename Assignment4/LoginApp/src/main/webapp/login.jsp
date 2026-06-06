<%@ page import="com.bean.LoginBean" %>

<jsp:useBean id="loginBean" class="com.bean.LoginBean" />

<jsp:setProperty name="loginBean" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

<%
if(loginBean.validateUser()){
%>

<h2>Login Success</h2>

<%
}else{
%>

<h2>Login Failed</h2>

<%
}
%>

</body>
</html>