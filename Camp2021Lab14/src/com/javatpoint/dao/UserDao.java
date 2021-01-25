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
	    
	    System.out.println("===> JDBC로 save() 기능 처리");
	    System.out.println(u.getTitle()+"-"+u.getWriter()+"-"+u.getContent() +"-"+ u.getImage());
	    try{  
	    	
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into BOOK(title,writer,content,image) values(?,?,?,?)");  
	        ps.setString(1,u.getTitle());  
	        ps.setString(2,u.getWriter());  
	        ps.setString(3,u.getContent());
	        ps.setString(4,u.getImage()); 
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	    
	}  
	
	public static int update(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update BOOK set title=?,writer=?,content=?, image=? where seq=?");  
	        ps.setString(1,u.getTitle());  
	        ps.setString(2,u.getWriter());  
	        ps.setString(3,u.getContent());
	        ps.setString(4,u.getImage());
	        ps.setInt(5,u.getSeq());  
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
	            u.setWriter(rs.getString("writer"));  
	            u.setContent(rs.getString("content"));
	            u.setImage(rs.getString("image"));
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
	            u.setTitle(rs.getString("title"));  
	            u.setWriter(rs.getString("writer"));  
	            u.setContent(rs.getString("content"));
	            u.setImage(rs.getString("image"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}
}
