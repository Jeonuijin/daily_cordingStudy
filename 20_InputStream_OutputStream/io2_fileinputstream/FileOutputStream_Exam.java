package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOutputStream_Exam {

	public static void main(String[] args) {
		File file = new File("file/test_out_01.txt");
	
		FileOutputStream fos = null;
		//FileOutputStream : byte 단위로 파일에 저장(출력, 쓰기)

		
		try {
			//1. 사용할 객체(인스턴스) 생성
			//fos = new FileOutputStream(file); //새로작성(기존내용 삭제 후 쓰기)
			fos = new FileOutputStream(file, false); //내용추가모드 true = yes/ false=no (false생략가능)
			
			//2. 객체 사용해서 작업처리
			fos.write('H');
			fos.write('E');
			fos.write('L');
			fos.write('O');
			fos.write('\n');
			
			byte[] bytes = "Hello Java!!!".getBytes();
			System.out.println("bytes : " + Arrays.toString(bytes));
			fos.write(bytes);
			fos.write('\n');
			
			//			시작위치,사용갯수
			fos.write(bytes, 0, bytes.length);
			fos.write('\n');
			
			 fos.write(bytes, 6, 7); // 6번 인덱스에서부터 7개 작성
	
		
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) { // fos.write('H') 의 예외처리
			e.printStackTrace();
			//3. 사용객체 close
		}finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

}
