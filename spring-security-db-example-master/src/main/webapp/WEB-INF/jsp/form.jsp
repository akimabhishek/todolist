<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Page</title>
</head>
<body>
	<form action="formsave" method="post">
		<input type="text" name="emailid">
		<input type="submit" value="Submit">
	</form>
	<c:forEach items="${tasklist}" var="t">
			<tr>						
				<td><c:out value="${t.taskname}" /></td>
				<td><c:out value="${t.id}" /></td>
				<td><c:out value="${t.user_id}"/></td>
				<td>
					<a href="delete/${t.id}">Delete</a>
					<a href="edit/${t.id}/${t.user_id}">Edit</a>
					<a href="new_task/${t.user_id}">New task</a>
				</td>		
			</tr>
	</c:forEach>	
		
</body>
</html>