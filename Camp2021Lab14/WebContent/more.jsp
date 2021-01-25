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

<h1>More Form</h1>  
 
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>  
<table>  
<tr><td>Title:</td><td>  
<input type="text" name="title" value="<%= u.getTitle()%>" readonly/></td></tr>  
<tr><td>Author:</td><td>  
<input type="text" name="writer" value="<%= u.getWriter()%>" readonly/></td></tr>
<tr><td>Photo:</td><td>  
<img src="${pageContext.request.contextPath }/upload/<%=u.getImage()%>" style="height:150px;"/></td></tr>    
<tr><td>Content:</td><td>  
<input type="text" name="content" value="<%= u.getContent()%>" readonly/></td></tr>      
<button><a href="viewusers.jsp">Go to List</a></button>
</table>  
</body>
</html>