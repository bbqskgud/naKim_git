package dbprac;

import java.sql.SQLException;
import java.util.Scanner;

public class tell {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Db db=new Db();
		
		while(true) {
			System.out.println("1.�Է� 2.��� 3.���� 4.���� 5.����");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.println("�̸� : ");
				String name =sc.nextLine();
				System.out.println("��ȭ��ȣ : ");
				String tell =sc.nextLine();
				db.insert(name, tell);
				
			}else if(s==2) {//���
				db.selectlist();
			}else if(s==3) {//����
				System.out.println("������ ����� �̸�");
				String name=sc.nextLine();
				System.out.println("������ ��ȣ");
				String tell=sc.nextLine();
				
				db.update(name, tell);
			}else if(s==4) {//����
				System.out.println("������ ����� �̸�");
				String name=sc.nextLine();
				db.delete(name);
			}else if(s==5) {//����
				break;
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}			
		}
		System.out.println("���α׷� ����");			
	}

}
