package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	 
	
	public Db() {
		//�����Ҷ� �ʿ��ѿ�ҵ�
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1234";
		//ó���� ����̹� ã�� �޸��忡 ��������
		//�ι�° Ŀ�ؼ� �ϱ�/ �ٸ��ʿ� �����ִ°͵��� �ʵ忡 ����
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	public Statement getStatement() {
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
		
	public PreparedStatement getPreparedStatement(String sql) {
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
}
