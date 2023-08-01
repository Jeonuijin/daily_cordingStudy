package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.FieldPosition;
import java.util.Arrays;


//2번반복문다시
public class FileInputStream_Ex3__2 {

	public static void main(String[] args) {
		// (실습) Ex3_1 파일을 반복문으로 변경
		
		//0. 사용할 파일객체 생성
		File file = new File("file/test02.txt");
		
		FileInputStream fis = null; 
		
		try {
			//1. 파일을 읽어서 작업할 객체 생성(FileInputStream)
			fis = new FileInputStream(file);
			
			//2. 객체 사용 파일데이터 읽어서 화면출력(byte[] 사용, 반복문으로 반복처리)
			byte[] bytes = new byte[10];
			int readCnt = fis.read(bytes);
//			int readValue = fis.read();
			System.out.println("읽은 갯수 : " + readCnt);
			System.out.println(Arrays.toString(bytes));
			
//			while ((readValue = fis.read()) != -1) {
//				System.out.println("fis.read() int값 : " + readValue);
//			}
			while (true) {
				if((readCnt = fis.read(bytes)) != -1) break;
				for (int i = 0; i < readCnt; i++) {
					System.out.println("int : " + bytes[i] + " (char) : " 
										+ (char)bytes[i]);
				}
			}
//			
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //3. 객제 닫기 (close)
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}

}
