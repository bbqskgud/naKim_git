package db02;

import java.io.Serializable;

public class Member implements Serializable{//멤버라서 시리얼라이즈블하는듯
	private int num;//자동증가값 auto_INCREMENT-->디비에서 테이블을 새로만듬
	private String name;
	private String id;
	private String pass;
	private String email;
	public Member() {}
	//생성자만들기 소스-컨스트럭트 유징필드
	//생성자에서 넘버는 받을필요가없음
	//public Member( int number,String name, String id, String pass, String email)
	public Member(String name, String id, String pass, String email) {
//		super();		
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.email = email;
		
	}
	//겟셋만들기 소스-제네레이터 겟셋
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
