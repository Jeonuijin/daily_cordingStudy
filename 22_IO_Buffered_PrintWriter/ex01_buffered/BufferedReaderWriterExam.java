package com.mystudy.ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있ㄴ느 글ㄹ스
		// 버퍼 : 데이터를 저장하는 공간(메모리상에)
		// BufferedReader, bufferedReder
		// File -> FileReader -> BufferedReader
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		
		try {
			// 파일로부터 읽기위한 객체(인스턴스) 생성
			File inFile = new File("file/test_buf_rw_in.txt");
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);//버퍼기능 + 파일읽기 기능

			// 파일에 쓰기 위한 객체 생성
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bw = new BufferedWriter(fw); // 버퍼기능 + 파일쓰기 기능
			
			// 파일에 먼저 쓰기
			bw.write("안녕하세요. 자바공부중입니다.\n");
			bw.write("Hello Java!!!");
			bw.newLine(); //줄바꿈처리방법 1.\n  2.newLine()
			bw.write("재미있나요???");
			bw.newLine();
			bw.write("-----------------");
			bw.newLine();
			
			bw.flush();
			
			// 파일로부터 읽고, 파일에 쓰기(버퍼기능 사용)
			// 파일에서 읽기(한번 읽기)
			String str = br.readLine(); //한 줄(라인) 읽기
			System.out.println("readLine() 읽은 값 : " + str);
			
			//파일에 쓰기(한 번 쓰기)
			
			bw.write(str); //문자열출력
			bw.newLine(); // 줄바꿈처리
			
			//남은 데이터 모두 읽고쓰기
			str = br.readLine();  //int값일때는 값이없는경우 -1을 리턴,String은 null을 리턴
			while (str != null) {
				bw.write(str);
				bw.newLine();
				if (str != null) { //써도 되고 안써도됨.(null이아니면 줄바꿈해라)
					str = br.readLine(); 
				}
			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				} try {
					if (bw != null) bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.out.println("---- main() 끝 ----");
	}

}
