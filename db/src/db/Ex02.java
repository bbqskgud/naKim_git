package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {

	public static void main(String[] args) {//����ó���Ҷ� ���⽱���� try catch���
		//�̰��� ����̹� �Ŵ����Ŀ� ���
		String url="jdbc:mariadb://localhost:3306/java";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("OK");
			//ok���� ���� �����۾�����. 1�ܰ�κ�
			//2�ܰ�� Ŀ�ؼ��� �δ°�.
			Connection conn = DriverManager.getConnection(url, user, password);
			//Connection conn�� ���������ֱ�
			System.out.println(conn);
			Statement stm=conn.createStatement();
			//create�������� getConnectio�ڿ� ���� �������־
			//Statement�� ������ �����ؼ� �����ϴ¹�
			//����Ʈ�Ҷ� sql�� �Ұ� ����
			//stm�̿��Ͽ� ���� �ޱ�
			ResultSet rs=stm.executeQuery("select * from ex02");
			//�̰��Ѵ��� �ݺ��ϵ��� for��������
			while(rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2));
			}
			//���Ŀ� ���� �͵� �ݱ� ������ �ݳ�.
			rs.close();
			stm.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ����."+e);
			//���� ������ ��������� e�� �־ ��ü������ ����.
		}catch (SQLException e) {
			System.out.println("===>"+e);

	}
	}
}
