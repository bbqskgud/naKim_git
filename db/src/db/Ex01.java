package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 OK");
			Connection conn = null;
			//사용하려고 커넥션만듬
			String url= "jdbc:mariadb://localhost:3306/java";
			//여기에 자신의 localhost부분에ip넣으면됨
			String id = "root";
			String pass= "1234";
			//이거는 내비밀번호
			conn=DriverManager.getConnection(url,id,pass);
			System.out.println("====>"+conn);
			Statement stmt=conn.createStatement();
			//conn으로 스태이트먼트만들려고함.
			//Statement인터페이스지만 구현타입이 오기 때문에 객체가능
			System.out.println("====>"+stmt);
			ResultSet rs = stmt.executeQuery("select * from test");
			//하기전에 녹색sql프로그램에서 테이블만들어서 사용
			//그다음 결과값 보기위해 rs정의
			while(rs.next()) {//rs다음값이 있는지 읽는것 .next 데이터수많큼 돈다.
				System.out.println(rs.getInt(1)+":"+rs.getString(2));
			}//결과 rs에서 1번째인 번호와 2번째인 이름을 나타낸다.
			rs.close();
			stmt.close();
			conn.close();
			//실행한것의 역으로 닫아줘야가능
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음");
		} catch ( SQLException e) {
			System.out.println(e);
		}

	}

}
