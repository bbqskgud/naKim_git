package db;


import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		
		Db db=new Db();
		
		while(true) {
			System.out.print("1.입력 2.출력 3.삭제 4.수정 0.종료");
			int s=Integer.parseInt(sc.nextLine());
			if(s==1) {				
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("주민번호 : ");
				String jumin = sc.nextLine();
				int a=db.insert(name, jumin);
				if(a==0) //리턴값이1이라면
					System.out.println("insert성공");
				
				
			}else if(s==2) {
				db.selectlist();
				
			}else if(s==3) {
				System.out.print("이름");
				String name=sc.nextLine();
				int a=db.delete(name);
				if(a==1) //리턴값이1이라면
					System.out.println("delete성공");
			}
			else if(s==4) {
				System.out.print("주민번호");
				String jumin=sc.nextLine();
				System.out.print("바꿀 이름");
				String name=sc.nextLine();
				int a=db.update(jumin,name);
				if(a==1) //리턴값이1이라면
					System.out.println("update성공");
			}
			else if(s==0) {
				//브레이크를 걸고 바깥에서 커넥션을 닫음
				break;
			}
			
		}
		System.out.println("프로그램 종료");		
			JdbcUtil.close(db.getConn());
			
		}
	

}
