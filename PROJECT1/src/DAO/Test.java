package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


import VO.MemberVO;

public class Test {

	public static void main(String[] args) {
		
	
	

		

			MemberDAO memberDAO = new MemberDAO();

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//Scanner scan = new Scanner(System.in);

			

			try {
				System.out.println("회원가입");
				System.out.println("ID : ");
				String strTemp = br.readLine();
				System.out.println("비밀번호 : ");
				String strTemp1 =br.readLine();
				System.out.println("이름입력 : ");
				String strTemp2 = br.readLine();
				System.out.println("Email : ");
				String strTemp3 = br.readLine();
				System.out.println("휴대폰번호 : ");
				String strTemp4 = br.readLine();
				
				int i = 1;
				MemberVO vo = new MemberVO(i++,strTemp, strTemp1, strTemp2, strTemp3, strTemp4);
				int result1 = memberDAO.insert(vo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			//scan.close();
			

	}

}

