<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.javatpoint.dao.UserDao,com.javatpoint.bean.User"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
String seq=request.getParameter("seq");  
User u=UserDao.getRecordById(Integer.parseInt(seq));  
%>

<h1>Edit Form</h1>  
<form action="edituser.jsp" method="post">  
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>  
<table>  
<tr><td>Title:</td><td>  
<input type="text" name="title" value="<%= u.getTitle()%>"/></td></tr>  
<tr><td>Author:</td><td>  
<input type="text" name="author" value="<%= u.getAuthor()%>"/></td></tr>  
<tr><td>Comment:</td><td>  
<input type="text" name="comment" value="<%= u.getComment()%>"/></td></tr>      
<tr><td colspan="2"><input type="submit" value="Edit User"/>Update</td></tr> 
</table>  
</form>  

</body>
</html>