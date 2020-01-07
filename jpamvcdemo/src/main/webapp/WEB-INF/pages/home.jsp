<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>
Id is  <c:out value="${user.id}"/>
Name is <c:out value="${user.name}"/>
</h2>

<a href="/signout">Sign out</a>

</body>
</html>