package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("전화번호 : ");
		String num_ber=sc.nextLine();
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1234";
		//String query="insert into ex02 values("+name+","+num_ber+"")";
		//query결합하면 열몇줄씩생겨서 복잡함
		String query="insert into ex02 values(?,?)";
		//대신 이거사용
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//forname안에는 찾을곳
			System.out.println("OK");
			Connection conn=DriverManager.getConnection(url, user, pwd);
			//conn.createStatement();
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1,name);
			pstm.setString(2,num_ber);
			pstm.executeUpdate();
			//값을 db에 업데이트해주는것
			//이제 닫아준다.
			pstm.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 못 찾음");
		}catch (SQLException e) {
			System.out.println("====>"+e);
		}
		
		
	}

}
