package db02;

//다른곳에 있는거 당겨쓰기.
import db.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.*;


public class Db {
	private Connection conn;//외부에서 쓸거면 겟
	
	public Connection getConn() {
		return conn;
	}

	public Db() {
		try {
			String url="jdbc:mariadb://localhost:3306/java";
			String user="root";
			String pwd="1234";
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
	public boolean registMember(Member member) {//회원가입
		String query="insert into ex05 values(null,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPass());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt);
			return true;
			
		} catch (SQLException e) {
			System.out.println("회원가입 실패 :"+e);
			e.printStackTrace();
		}
						
		return false;	
		
	}
	public boolean loginMember(Member member) {//로그인
		String query="SELECT*FROM ex05 WHERE id=? AND pass=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getId());//?받는 문장
			pstmt.setString(2, member.getPass());
			ResultSet rs=pstmt.executeQuery();//db에 넣어주는코딩
			if(!rs.next()) {//다음값이 없을때
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				return false;
			}
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		} catch (SQLException e) {
			System.out.println("로그인 실패");
		}
		
		
		return true;
	}
	public boolean deleteMember(String id) {
		String query="delete from ex05 where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt);
			
			
		} catch (SQLException e) {
			System.out.println("회원삭제 실패");
			return false;
			
		}		
		
		return true;
	}
	public boolean editMember(Member member) {
		String query="update ex05 set name=?,pass=?,email=? where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt);
			
			
		} catch (SQLException e) {
			System.out.println("회원수정 실패");
			return false;
			
		}		
		
		return true;
	}
}


