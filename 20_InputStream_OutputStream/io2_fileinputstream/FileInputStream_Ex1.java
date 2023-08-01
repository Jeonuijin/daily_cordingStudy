package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		System.out.println("==== main() 시작 ====");
		File file = new File("temp.txt");
		
		FileInputStream fis = null; // 초기화가 필요한 이유 : 로컬변수는 값이 저장된 상태로 써야하고, 
		// 예외가 발생한경우 try문을 거치지 못하기 때문에 fis.close를 사용하지 못한다.
		try {
			// 파일로부터 읽기 위한 작업 진행
			// 1. 사용할 객체 생성
			fis = new FileInputStream(file); // 중괄호 기준으로 중괄호 내에 선언된 변수는 다른 곳에서 사용이 안된다.

			// 2. 객체 사용 작업 처리
			int readValue = fis.read();
			System.out.println("read() int값 : " + readValue);
			System.out.println("(char)read() : " + (char)readValue);
			
			System.out.println("--- 전체 데이터 읽어서 화면출력 ---");
			
			while (true) {
				// EOF (End Of File) 를 만나면 (더 이상 읽을 것이 없으면) -1 리턴
				readValue = fis.read();
				if (readValue == -1) break;
				System.out.println("read() int값 : " + readValue);
				System.out.println("(char)read() : " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("[예외발생]" + e.getMessage());
		} catch (IOException e) { //fis.read();의 예외처리부분
			e.printStackTrace();
		} finally {
			// 3. 객체 사용 후 닫기 (close) // 작업처리 후 파일에 연결되어있는 통로를 닫아주는게 안전하다.
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("==== 끝 =====");
	}

}
