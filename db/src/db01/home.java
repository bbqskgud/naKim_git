package db01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class home {

	public static void main(String[] args) {
		Db db= new Db();
		Scanner sc=new Scanner(System.in);
		int kor = 0;
		int eng =0;
		int mat=0;
		int tot=0;
		float avg=0;
							
		
		while(true) {
			System.out.println("1.입력 2.총점,평균 3.삭제 4.수정 0.종료");
			int s=Integer.parseInt(sc.nextLine());
			
			if(s==1) {//입력
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("국어 : ");
				kor=Integer.parseInt(sc.nextLine());
				System.out.print("영어 : ");
				eng=Integer.parseInt(sc.nextLine());
				System.out.print("수학 : ");
				mat=Integer.parseInt(sc.nextLine());
				String query="insert into ex03 values (?,?,?,?,?,?)";
				PreparedStatement pstmt = db.getPreparedStatement(query);
				
				try {
					pstmt.setString(1, name);
					pstmt.setInt(2, kor);
					pstmt.setInt(3, eng);
					pstmt.setInt(4, mat);
					pstmt.setInt(5, (kor+eng+mat));
					pstmt.setFloat(6, (kor+eng+mat)/3);					
					pstmt.executeUpdate();
					pstmt.close();
					
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(s==2) {//총점 평균 조회
				Statement stmt =db.getStatement();
				try {
					ResultSet rs=stmt.executeQuery("SELECT * FROM ex03");
					while(rs.next()) {
						System.out.println(rs.getString(1)+"-"+"국어:"+rs.getString(2)+" "+
								"영어:"+rs.getString(3)+" "+"수학:"+rs.getString(4)+" "+"총점:"
								+rs.getString(5)+" "+"평균:"+rs.getString(6));
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
																				
			}else if(s==3) {//삭제
				System.out.print("삭제 할 이름 : ");
				String name=sc.nextLine();
				String query="DELETE FROM ex03 WHERE NAME=?";
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
				System.out.print("성적 수정 할 이름 : ");
				String name=sc.nextLine();
				System.out.print("수정 할 과목 : 1.국어 2.영어 3.수학");
				int sj=Integer.parseInt(sc.nextLine());
				if(sj==1) {
					System.out.print("국어 : ");
					kor=Integer.parseInt(sc.nextLine());
				}else if(sj==2) {
					System.out.print("영어 : ");
					eng=Integer.parseInt(sc.nextLine());
				}else if(sj==3) {
					System.out.print("수학 : ");
					mat=Integer.parseInt(sc.nextLine());
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				String query="update ex03 set kor=?,eng=?,mat=?,tot=?,avg=? WHERE NAME=?";
				PreparedStatement pstmt=db.getPreparedStatement(query);
				
				try {
					pstmt.setInt(1, kor);
					pstmt.setInt(2, eng);
					pstmt.setInt(3, mat);
					pstmt.setInt(4, (kor+eng+mat));
					pstmt.setFloat(5, (kor+eng+mat)/3);
					pstmt.setString(6, name);
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}else if(s==0) {//종료
				System.out.println("시스템 종료");
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
