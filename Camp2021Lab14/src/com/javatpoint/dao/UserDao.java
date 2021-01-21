package com.javatpoint.dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.javatpoint.bean.User;  

public class UserDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/hgucseejs","jeeseul","flej^^6433");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}
	
	public static int save(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into BOOK(title,author,comment) values(?,?,?)");  
	        ps.setString(1,u.getTitle());  
	        ps.setString(2,u.getAuthor());  
	        ps.setString(3,u.getComment()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	public static int update(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update BOOK set title=?,author=?,comment=? where seq=?");  
	        ps.setString(1,u.getTitle());  
	        ps.setString(2,u.getAuthor());  
	        ps.setString(3,u.getComment()); 
	        ps.setInt(4,u.getSeq());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	
	public static int delete(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from BOOK where seq=?");  
	        ps.setInt(1,u.getSeq());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}
	
	public static List<User> getAllRecords(){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from BOOK");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User u=new User();  
	            u.setSeq(rs.getInt("seq"));  
	            u.setTitle(rs.getString("title"));  
	            u.setAuthor(rs.getString("author"));  
	            u.setComment(rs.getString("comment")); 
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	
	public static User getRecordById(int seq){  
	    User u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from BOOK where seq=?");  
	        ps.setInt(1,seq);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new User();  
	            u.setSeq(rs.getInt("seq"));  
	            u.setTitle(rs.getString("name"));  
	            u.setAuthor(rs.getString("author"));  
	            u.setComment(rs.getString("comment"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}
}
