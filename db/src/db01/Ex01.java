package db01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//커넥션이 맺어졌는지 확인하기

public class Ex01 {
	
	public static void main(String[] args) {
		Db db = new Db();//이래야 커넥션생김
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.입력 2.출력 3.삭제 4.수정 0.종료");
			int s=Integer.parseInt(sc.nextLine());
			
			if(s==1) {
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("전화번호 : ");
				String num_ber=sc.nextLine();
				//Statment필요 동적 쿼리
				String query="insert into ex02 values(?,?)";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				try {
					pstmt.setString(1, name);
					pstmt.setString(2, num_ber);
					pstmt.executeUpdate();
					pstmt.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}else if(s==2) {//출력
				Statement stmt =db.getStatement();
				try {
					ResultSet rs=stmt.executeQuery("select * from ex02");
					while(rs.next()) {
						System.out.println(rs.getString(1)+":"+rs.getString(2));
					}
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
			}else if(s==3) {//1번참조해서 하기
				System.out.print("삭제 할 이름 : ");
				String name=sc.nextLine();
				String query="DELETE FROM ex02 WHERE NAME=?";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				try {
					pstmt.setString(1,name);
					pstmt.executeUpdate();
					pstmt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(s==4) {//수정
				System.out.print("전화번호 수정 할 이름 : ");
				String name=sc.nextLine();
				System.out.print("수정 할 전화번호 : ");
				String num_ber=sc.nextLine();
				String query="UPDATE ex02 SET NUM_BER=? WHERE NAME=?";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				try {
					pstmt.setString(1, num_ber);
					pstmt.setString(2,name);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			else if(s==0) {
				System.out.println("프로그램 종료");
				try {
					db.getConn().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		}
		
	}

}
