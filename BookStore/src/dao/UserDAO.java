package dao;
import dao.DBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public static UserDAO Instance=null;
	
	private UserDAO(){
		
	}
	
	public static UserDAO getInstance(){
		if(Instance==null){
			Instance=new UserDAO();
		}
		return Instance;
	}
	
	public void addUser(){
		
	}
	
	public void delUser(){
		
	}
	
	public void updateUser(){
		
	}
	
	public void selectUser(){
		
	}
	
}
