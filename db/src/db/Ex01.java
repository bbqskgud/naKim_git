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
			System.out.println("����̹� OK");
			Connection conn = null;
			//����Ϸ��� Ŀ�ؼǸ���
			String url= "jdbc:mariadb://localhost:3306/java";
			//���⿡ �ڽ��� localhost�κп�ip�������
			String id = "root";
			String pass= "1234";
			//�̰Ŵ� ����й�ȣ
			conn=DriverManager.getConnection(url,id,pass);
			System.out.println("====>"+conn);
			Statement stmt=conn.createStatement();
			//conn���� ������Ʈ��Ʈ���������.
			//Statement�������̽����� ����Ÿ���� ���� ������ ��ü����
			System.out.println("====>"+stmt);
			ResultSet rs = stmt.executeQuery("select * from test");
			//�ϱ����� ���sql���α׷����� ���̺��� ���
			//�״��� ����� �������� rs����
			while(rs.next()) {//rs�������� �ִ��� �д°� .next �����ͼ���ŭ ����.
				System.out.println(rs.getInt(1)+":"+rs.getString(2));
			}//��� rs���� 1��°�� ��ȣ�� 2��°�� �̸��� ��Ÿ����.
			rs.close();
			stmt.close();
			conn.close();
			//�����Ѱ��� ������ �ݾ���߰���
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ����");
		} catch ( SQLException e) {
			System.out.println(e);
		}

	}

}
