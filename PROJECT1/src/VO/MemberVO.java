package VO;
/*
오라클 테이블 코드 : 회원관리
CREATE TABLE MEMBER (
MEMBER_ID NUMBER(38) CONSTRAINT PK_MEMBER PRIMARY KEY,
CUST_ID	VARCHAR2(100) NOT NULL,
CUST_PASSWORD VARCHAR2(100) NOT NULL,
CUST_NAME VARCHAR2(100) NOT NULL,
CUST_EMAIL VARCHAR2(300) NULL,
CUST_PHONE VARCHAR2(50) NOT NULL,
CUST_POINT NUMBER(38) DEFAULT 0
);

 */

public class MemberVO {
	private int Member_ID;
	private String Cust_id;
	private String Cust_password;
	private String Cust_name;
	private String Cust_email;
	private String Cust_phone;

	
	public MemberVO() {}
	
	public MemberVO(int member_id, String cust_id, String cust_password, String cust_name, String cust_email,
			String cust_phone) {
		super();
		Member_ID = member_id;
		Cust_id = cust_id;
		Cust_password = cust_password;
		Cust_name = cust_name;
		Cust_email = cust_email;
		Cust_phone = cust_phone;
	}

	public int getMember_ID() {
		return Member_ID;
	}

	public void setMember_ID(int member_ID) {
		Member_ID = member_ID;
	}

	public String getCust_id() {
		return Cust_id;
	}

	public void setCust_id(String cust_id) {
		Cust_id = cust_id;
	}

	public String getCust_password() {
		return Cust_password;
	}

	public void setCust_password(String cust_password) {
		Cust_password = cust_password;
	}

	public String getCust_name() {
		return Cust_name;
	}

	public void setCust_name(String cust_name) {
		Cust_name = cust_name;
	}

	public String getCust_email() {
		return Cust_email;
	}

	public void setCust_email(String cust_email) {
		Cust_email = cust_email;
	}

	public String getCust_phone() {
		return Cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		Cust_phone = cust_phone;
	}



	@Override
	public String toString() {
		return "회원 고유 키 = " + Member_ID + ", 아이디 = " + Cust_id + ", 비밀번호 = " + Cust_password
				+ ", 회원이름 = " + Cust_name + ", 이메일 = " + Cust_email + ", 전화버노 = " + Cust_phone
				+ ", 누적포인트 = " +"]";
	}
	
}
