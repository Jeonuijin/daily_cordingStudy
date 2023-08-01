package com.mystudey.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam2 {

	public static void main(String[] args) {
		// FileReader_Exam1 내용을 반복문으로 변경처리
		
		File file = new File("file/test_char.txt");

		FileReader fr = null;

		try {
			// 1. 객체 생성
			fr = new FileReader(file);

			// 2. 객체 사용
			int read = fr.read(); //변수에 저장을 안하고 fr.read()를 각각 쓰면 제각각 다른 값을 쓰게 된다. 재사용하기위해 변수사용
			while ((read = fr.read()) != -1) {
				System.out.println("값 : " + read + " char : " + (char) read);
			}
			
			
//			while (true ) {
//				int read = fr.read();
//				if (read == -1) break;
//				System.out.println("값 : " + read + " char : " + (char) read);
//			}

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(">>[예외] 파일없음");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(">>[예외] 파일을 읽지 못함");
			// 3. 사용객체 닫기(close)
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
