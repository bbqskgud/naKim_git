package db02;

import java.util.Scanner;

import db.JdbcUtil;

public class Main {

	public static void main(String[] args) {
		Db db= new Db();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.삭제 4.수정 0.종료");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("아이디 : ");
				String id=sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd=sc.nextLine();
				System.out.print("이메일 : ");
				String email=sc.nextLine();
				
				//멤버객체 생성을한다
				Member member=new Member(name,id,pwd,email);
				boolean a=db.registMember(member);
				if(a) {
					System.out.println("회원가입 성공");
				}
				
			}else if(s==2) {
				System.out.print("아이디 : ");
				String id=sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd=sc.nextLine();
				Member member=new Member();
				member.setId(id);
				member.setPass(pwd);
				
				if(db.loginMember(member)) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패");
				}
				
			}else if(s==3) {
				System.out.print("삭제할 아이디 : ");
				String id=sc.nextLine();
				if(db.deleteMember(id)) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
			}else if(s==4) {
				System.out.print("수정할 아이디 : ");
				String id=sc.nextLine();
				System.out.print("이름 : ");
				String name=sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd=sc.nextLine();
				System.out.print("이메일 : ");
				String email=sc.nextLine();
								
				Member member=new Member(id,name,pwd,email);
				if(db.editMember(member)) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
			}
			else if(s==0) {
				break;
				
			}
		}
		System.out.println("프로그램 종료.");
		JdbcUtil.close(db.getConn());
	}

}
