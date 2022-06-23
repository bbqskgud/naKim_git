package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {

	public static void main(String[] args) {//예외처리할때 보기쉽도록 try catch사용
		//이것은 드라이버 매니저후에 사용
		String url="jdbc:mariadb://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("OK");
			//ok문이 떠야 다음작업가능. 1단계부분
			//2단계는 커넥션을 맺는것.
			Connection conn = DriverManager.getConnection(url, user, password);
			//Connection conn는 임폴드해주기
			System.out.println(conn);
			Statement stm=conn.createStatement();
			//create정적쿼리 getConnectio뒤에 값이 정해져있어서
			//Statement는 쿼리를 생성해서 수행하는문
			//임폴트할때 sql꺼 할것 주의
			//stm이용하여 값을 받기
			ResultSet rs=stm.executeQuery("select * from ex02");
			//이거한다음 반복하도록 for문도가능
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2));
			}
			//이후에 열은 것들 닫기 값들을 반납.
			rs.close();
			stm.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없다."+e);
			//만약 오류를 보고싶으면 e를 넣어서 구체적으로 보기.
		}catch (SQLException e) {
			System.out.println("===>"+e);

	}
	}
}
