package db;


import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		
		Db db=new Db();
		
		while(true) {
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.����");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {				
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				System.out.print("�ֹι�ȣ : ");
				String jumin = sc.nextLine();
				int a=db.insert(name, jumin);
				if(a==0) //���ϰ���1�̶��
					System.out.println("insert����");
				
				
			}else if(s==2) {
				db.selectlist();
				
			}else if(s==3) {
				System.out.print("�̸�");
				String name=sc.nextLine();
				int a=db.delete(name);
				if(a==1) //���ϰ���1�̶��
					System.out.println("delete����");
			}
			else if(s==4) {
				System.out.print("�ֹι�ȣ");
				String jumin=sc.nextLine();
				System.out.print("�ٲ� �̸�");
				String name=sc.nextLine();
				int a=db.update(jumin,name);
				if(a==1) //���ϰ���1�̶��
					System.out.println("update����");
			}
			else if(s==0) {
				//�극��ũ�� �ɰ� �ٱ����� Ŀ�ؼ��� ����
				break;
			}
			
		}
		System.out.println("���α׷� ����");		
			JdbcUtil.close(db.getConn());
			
		}
	

}
