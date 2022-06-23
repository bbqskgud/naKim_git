package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1234";
		String query="insert into ex02 values(?,?)";
		//밑에 두개는 필드로 나와서 값을 초기화 시켜줘야하는것 처음쓴거처럼쓰면 값이 인식안되서 정의해야함
		Connection conn=null;
		PreparedStatement pstm = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e1) {
					//Class가 못찾는 예외
		} catch (SQLException e) {
					//SQLE문 오류났을때
			e.printStackTrace();
		}
		while(true) {
			System.out.println("1.입력 2.출력 3.종료");
			int s=Integer.parseInt(sc.nextLine());
			//왠만하면 nextLine사용해서 파싱해서 사용하기.
			if(s==1) {
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("전화번호 : ");
				String num_ber=sc.nextLine();
				try {
					pstm=conn.prepareStatement(query);
					//prepare은 동적쿼리:getConnectio에 넣는 쿼리에 ??써서 값이 변하므로 사용함
					pstm.setString(1,name);
					pstm.setString(2,num_ber);
					pstm.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
			}
			else if(s==2) {
					
				}
				
			else if(s==3) {
				try {
					pstm.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				System.exit(0);
			}
		}

	}

}
