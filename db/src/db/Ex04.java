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
		//�ؿ� �ΰ��� �ʵ�� ���ͼ� ���� �ʱ�ȭ ��������ϴ°� ó������ó������ ���� �νľȵǼ� �����ؾ���
		Connection conn=null;
		PreparedStatement pstm = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e1) {
					//Class�� ��ã�� ����
		} catch (SQLException e) {
					//SQLE�� ����������
			e.printStackTrace();
		}
		while(true) {
			System.out.println("1.�Է� 2.��� 3.����");
			int s=Integer.parseInt(sc.nextLine());
			//�ظ��ϸ� nextLine����ؼ� �Ľ��ؼ� ����ϱ�.
			if(s==1) {
				System.out.print("�̸� : ");
				String name=sc.nextLine();
				System.out.print("��ȭ��ȣ : ");
				String num_ber=sc.nextLine();
				try {
					pstm=conn.prepareStatement(query);
					//prepare�� ��������:getConnectio�� �ִ� ������ ??�Ἥ ���� ���ϹǷ� �����
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
