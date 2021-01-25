<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Book List</h1>
  
  <%
List<User> list=UserDao.getAllRecords();  
request.setAttribute("list",list);  
%>
<img src='./img/cat.webp' height='100px'>
<table border="1" width="90%">  
<tr><th>Title</th><th>Author</th><th>Comment</th> 
<th>Edit</th><th>Delete</th><th>More</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getTitle()}</td><td>${u.getWriter()}</td>  
<td>${u.getContent()}</td>
<td><a href="editform.jsp?seq=${u.getSeq()}">Edit</a></td>  
<td><a href="deleteuser.jsp?seq=${u.getSeq()}">Delete</a></td>
<td><a href="more.jsp?seq=${u.getSeq()}">more</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="adduserform.jsp"'>Add a Book</a>
</body>
</html>