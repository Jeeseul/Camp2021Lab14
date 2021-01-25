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
<form action="edituser.jsp" method="post" enctype="multipart/form-data">  
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>  
<table>  
<tr><td>Title:</td><td>  
<input type="text" name="title" value="<%= u.getTitle()%>"/></td></tr>  
<tr><td>Author:</td><td>  
<input type="text" name="writer" value="<%= u.getWriter()%>"/></td></tr>
<tr><td>Photo:</td><td>    
<input type="file" name="image" /><img src="${pageContext.request.contextPath }/upload/<%=u.getImage()%>" style="height:150px;"></td></tr>  
<tr><td>Content:</td><td>  
<input type="text" name="content" value="<%= u.getContent()%>"/></td></tr>      
<tr><td colspan="2"><input type="submit" value="Update"/></td></tr> 
</table>  
</form>  

</body>
</html>