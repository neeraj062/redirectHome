<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
<form method="get" action="logincheck">
<div>
<span>Id </span>
<input name="id" type="number" />
</div>
<div>
<span>Password</span>
<input name="password" type="password" />
</div>
<input type="submit" value="Submit"/>
</form>
</body>
</html>