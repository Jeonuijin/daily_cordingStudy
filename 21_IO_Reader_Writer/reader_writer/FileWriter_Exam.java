package com.mystudey.reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Exam {

	public static void main(String[] args) {
		System.out.println("---- main()시작 ------");
		// FileWriter : 파일에 문자단위 출력(쓰기)
		File file = new File("file/test_char_out.txt"); //파일까지만 만들고 디렉토리는 생성하지 않는다.

		FileWriter fw = null;
		
		try {
			//1. 객체(인스턴스) 생성
			fw = new FileWriter(file);
			
			//2. 객체 사용(파일에 문자단위 출력)
			fw.write('대');
			fw.write("한");
			fw.write("민국");
			
//			fw.flush(); //버퍼에 있는 데이터를 강제로 Output 처리, flush나 close 필수록사용
			
			fw.write("Hello Java!!!");
			
//			fw.flush(); //flush는 파일과 연결된 통로를 유지하면서 버퍼만 비운다. /close는 아예 통로를 닫음

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. 사용객체 닫기(close)	//버퍼의 기능이 있을경우 한번에 모았다가 전송하기 때문에 close처리가 필수다./아니면 flush처리
		} try {
			if (fw != null) fw.close();
		}catch (IOException e) {}
		
		System.out.println("---- main()끝 ------");
	}

}
