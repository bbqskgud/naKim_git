package db02;

import java.io.Serializable;

public class Member implements Serializable{//����� �ø����������ϴµ�
	private int num;//�ڵ������� auto_INCREMENT-->��񿡼� ���̺��� ���θ���
	private String name;
	private String id;
	private String pass;
	private String email;
	public Member() {}
	//�����ڸ���� �ҽ�-����Ʈ��Ʈ ��¡�ʵ�
	//�����ڿ��� �ѹ��� �����ʿ䰡����
	//public Member( int number,String name, String id, String pass, String email)
	public Member(String name, String id, String pass, String email) {
//		super();		
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.email = email;
		
	}
	//�ټ¸���� �ҽ�-���׷����� �ټ�
	
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
