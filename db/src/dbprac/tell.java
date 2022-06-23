package dbprac;

import java.sql.SQLException;
import java.util.Scanner;

public class tell {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Db db=new Db();
		
		while(true) {
			System.out.println("1.입력 2.출력 3.수정 4.삭제 5.종료");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {
				System.out.println("이름 : ");
				String name =sc.nextLine();
				System.out.println("전화번호 : ");
				String tell =sc.nextLine();
				db.insert(name, tell);
				
			}else if(s==2) {//출력
				db.selectlist();
			}else if(s==3) {//수정
				System.out.println("수정할 사람의 이름");
				String name=sc.nextLine();
				System.out.println("수정할 번호");
				String tell=sc.nextLine();
				
				db.update(name, tell);
			}else if(s==4) {//삭제
				System.out.println("삭제할 사람의 이름");
				String name=sc.nextLine();
				db.delete(name);
			}else if(s==5) {//종료
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
			}			
		}
		System.out.println("프로그램 종료");			
	}

}
