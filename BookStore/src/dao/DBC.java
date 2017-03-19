package dao;
import java.sql.*;
public class DBC {
	public static DBC Instance=null;
	private Connection con;
	private Statement stmt;
	private ResultSet rest;
	
	private DBC(){
		con=null;
		stmt=null;
		rest=null;
	}
	
	private void CloseAll(){
		if(rest!=null)
			try{
				rest.close();
				}catch(SQLException e){
					e.printStackTrace();
					}
		if(stmt!=null)
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		if(con!=null)
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public static DBC getInstance(){
		if(Instance==null){
			Instance=new DBC();
		}
		return Instance;
	}
	
	public static void freeInstance(){
		if(Instance!=null)
			Instance.CloseAll();
	}
	
	public Connection getConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","atin","123");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public Statement creStatement(){
		try{
			if(con!=null)
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return stmt;
	}
	
	public ResultSet creResultSet(String sql){
		try{
			if(stmt!=null)
			rest=stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rest;
	}
	
}
