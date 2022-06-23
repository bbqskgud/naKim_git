package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Db {
	private Connection conn;	
	
	public Db() {
		String url="jdbc:mariadb://localhost:3306/java";	
		String user="root";
		String pwd="1234";
						
		try {//�ؿ� ������ conn�� ����̹� �Ŵ����� �����Ѵ� Ŀ�ؼǾȿ��ִ� ��������� ��¶�
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
	
	//������ insert�� ����
	public int insert(String name,String jumin) {
		String query = "INSERT INTO ex04 VALUES(null,?,?)";
		PreparedStatement pstmt;
		int a=0;
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			a=pstmt.executeUpdate();			
			JdbcUtil.close(pstmt);
			//pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return a;//a�� ��� ���� �ߵ����� �Ǻ��ϴ°��̹Ƿ� �����Ҽ�����.
		
	}
	public void selectlist() {
		String query="select * from ex04";
		Statement smt;
		try {
			smt = conn.createStatement();
			//Statement smt������� conn�� �̿��ؼ�createStatement����
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
			}
			JdbcUtil.close(rs);
			JdbcUtil.close(smt);
//			rs.close();
//			smt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int delete(String name) {
		String query="delete from ex04 where name=?";
		int a;
		try {
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, name);
			a= pstm.executeUpdate();
			JdbcUtil.close(pstm);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	public int update(String jumin, String name) {
		String query="UPDATE ex04 SET NAME=? WHERE jumin =?";
		int a;
		try {
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, jumin);
			a= pstm.executeUpdate();
			JdbcUtil.close(pstm);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
	