package dbprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	public Db() {
		String url ="jdbc:mariadb://localhost:3306/java";
		String user ="root";
		String pwd ="1234";
			
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pwd);			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	public int insert(String name,String tell) {
		String query="insert into pr values(?,?)";
		PreparedStatement pstmt; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, tell);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
		
	}public void selectlist() {
		String query = "select * from pr";
		Statement smt;
		try {
			smt=conn.createStatement();
			rs=smt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(String name,String tell) {
		String query = "update pr set tell=? where name=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, tell);
			pstmt.setString(2, name);			
			pstmt.executeUpdate();
			//pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}public void delete(String name) {
		String query="delete from pr where name=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}
