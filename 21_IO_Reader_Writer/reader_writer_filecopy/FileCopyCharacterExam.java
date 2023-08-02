package com.mystudey.reader_writer_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		// FileReader, FileWriter 사용해서 파일 복사
		// 원본파일 : file/test_char.txt
		// 대상파일 : file/test_char_copy.txt
		// 처리 : 원본파일에서 읽고, 대상파일에 쓰기/저장(문자단위 처리)
		//--------------------------------------------
		
		//0. 사용할 파일(File) 객체 생성
		
		//1. FileReader, Filewriter 객체를 생성
		
		//2. 반복작업(원본파일에서 읽고, 대상파일에 쓰기 작업 반복)
		
		//3. 사용객체 닫기(close)
		//-------------------------------------------------------
		
		//0. 사용할 파일(File) 객체 생성
		File fileIn = new File("file/test_char.txt");
		File fileout = new File("file/test_char_copy.txt");
		
		FileReader reader = null;
		FileWriter writer = null;
		System.out.println("파일복사시작");
		
		try {
			//1. FileReader, Filewriter 객체를 생성
			//reader = new FileReader("file/test_char.txt"); //파일명을 알고있으면 직접 넣어줄수있다.
			reader = new FileReader(fileIn);
			writer = new FileWriter(fileout);
			
			//2. 반복작업(원본파일에서 읽고, 대상파일에 쓰기 작업 반복)			
			while (true) {
				int readValue = reader.read();
				if (readValue == -1) break;
				writer.write(readValue);
			}
			
			writer.flush(); //버퍼에 담겨있는 데이터를 강제로 출력처리
			System.out.println("파일복사끝");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. 사용객체 닫기(close)
			try {
				if (reader != null)
					reader.close();
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
	}