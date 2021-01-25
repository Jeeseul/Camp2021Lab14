<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="viewusers.jsp">View All Records</a><br/>  

<h1>Add New User</h1>  
<form action="adduser.jsp" method="post" accept-charset="UTF-8" enctype="multipart/form-data">  
<table>  
<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>  
<tr><td>Author:</td><td>  
<input type="text" name="writer"/></td></tr>
<tr><td>Photo:</td><td><input type="file" name="image"/></td></tr>  
<tr><td>Content:</td><td><input type="text" name="content"/></td></tr>    
<tr><td colspan="2"><input type="submit" value="Add List"/></td></tr>  
</table>  
</form>
</body>
</html>