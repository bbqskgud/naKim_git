package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		System.out.print("�̸� : ");
		String name=sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String num_ber=sc.nextLine();
		String url="jdbc:mariadb://localhost:3306/java";
		String user="root";
		String pwd="1234";
		//String query="insert into ex02 values("+name+","+num_ber+"")";
		//query�����ϸ� �����پ����ܼ� ������
		String query="insert into ex02 values(?,?)";
		//��� �̰Ż��
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//forname�ȿ��� ã����
			System.out.println("OK");
			Connection conn=DriverManager.getConnection(url, user, pwd);
			//conn.createStatement();
			PreparedStatement pstm=conn.prepareStatement(query);
			pstm.setString(1,name);
			pstm.setString(2,num_ber);
			pstm.executeUpdate();
			//���� db�� ������Ʈ���ִ°�
			//���� �ݾ��ش�.
			pstm.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �� ã��");
		}catch (SQLException e) {
			System.out.println("====>"+e);
		}
		
		
	}

}
