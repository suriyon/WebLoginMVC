package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.MySQLHelper;

public class UserDAO {
	public boolean checkLogin(User user){
		boolean result = false;
		String sql = "select password from user where username = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(user.getPassword().equals(rs.getString(1))){
					result = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
	public boolean insert(User user){
		boolean result = false;
		
		return result;
	}
		
	
}
