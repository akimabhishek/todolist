<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>Task Management</h1>
	<h2>
		<a href="/new">Add new task</a>
		&nbsp;&nbsp;&nbsp;
	</h2>
	</center>
	
	<div align="center">
		<c:if test="${task!=null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${task==null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
		
			<caption>
				<h2>
					<c:if test="${task!=null}">
					Edit Task
					</c:if>
					<c:if test="${task==null}">
						Add new task
					</c:if>		
				</h2>
			</caption>
				<c:if test="${task!=null}">
					<input type="hidden" name="id" value="<c:out value='${task.id}'/>"/>
				</c:if>
				
			<tr>
				<th>Task Name : </th>
				<td>
					<input type="text" name="task_name" size="45"
						value="<c:out value='${task.taskname}'/>"/>
				</td>		
			</tr>
			
			<tr>
				<th>Flag : </th>
				<td>
					<input type="text" name="flag" size="45"
					value="<c:out value='${task.flag}'/>"/>
			
			<tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>				
				
		</table>		
			</form>
	</div>
	
</body>
</html>