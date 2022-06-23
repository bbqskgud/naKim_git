package db02;

import java.util.Scanner;

import db.JdbcUtil;

public class Main {

	public static void main(String[] args) {
		Db db= new Db();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.ȸ������ 2.�α��� 3.���� 4.���� 0.����");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("�̸� : ");
				String name=sc.nextLine();
				System.out.print("���̵� : ");
				String id=sc.nextLine();
				System.out.print("��й�ȣ : ");
				String pwd=sc.nextLine();
				System.out.print("�̸��� : ");
				String email=sc.nextLine();
				
				//�����ü �������Ѵ�
				Member member=new Member(name,id,pwd,email);
				boolean a=db.registMember(member);
				if(a) {
					System.out.println("ȸ������ ����");
				}
				
			}else if(s==2) {
				System.out.print("���̵� : ");
				String id=sc.nextLine();
				System.out.print("��й�ȣ : ");
				String pwd=sc.nextLine();
				Member member=new Member();
				member.setId(id);
				member.setPass(pwd);
				
				if(db.loginMember(member)) {
					System.out.println("�α��� ����");
				}else {
					System.out.println("�α��� ����");
				}
				
			}else if(s==3) {
				System.out.print("������ ���̵� : ");
				String id=sc.nextLine();
				if(db.deleteMember(id)) {
					System.out.println("���� ����");
				}else {
					System.out.println("���� ����");
				}
			}else if(s==4) {
				System.out.print("������ ���̵� : ");
				String id=sc.nextLine();
				System.out.print("�̸� : ");
				String name=sc.nextLine();
				System.out.print("��й�ȣ : ");
				String pwd=sc.nextLine();
				System.out.print("�̸��� : ");
				String email=sc.nextLine();
								
				Member member=new Member(id,name,pwd,email);
				if(db.editMember(member)) {
					System.out.println("���� ����");
				}else {
					System.out.println("���� ����");
				}
			}
			else if(s==0) {
				break;
				
			}
		}
		System.out.println("���α׷� ����.");
		JdbcUtil.close(db.getConn());
	}

}
