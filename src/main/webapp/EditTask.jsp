<%@page import="java.time.Period"%>
<%@page import="dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		body {
			background-image:
				url("https://img.freepik.com/free-vector/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg");
			background-size: cover;
		}
	</style>
</head>
<body>
<%
Task task=(Task) request.getAttribute("task");
%>
<h1>Enter Task Details</h1>


	<form action="updatetask" method="post">
	<input type="text" name="id" value="<%=task.getId() %>"hidden required/th>
		<fieldset>
			<table>
				<tr>
					<th>Task Name: </th>
					<td><input type="text" name="name" value="<%=task.getName() %>"></td>
				</tr>
				<tr>
					<th>Task Description: </th>
					<td><input type="text" name="description" value="<%=task.getDescription() %>"></td>
				</tr>
				<tr>
					<th>Number of Days Required: </th>
					<td><input type="text" name="days" value="<%=Period.between(task.getTaskDate(),task.getCompletionDate()).getDays() %>"></td>
				</tr>
				<tr>
					<td><button>Add</button></td>
					<td><button type="reset">Cancel</button></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br>
	<a href="Home.jsp"><button>Back</button></a>
</body>
</html>
</body>
</html>