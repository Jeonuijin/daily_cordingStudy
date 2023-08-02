package com.mystudy.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_OutputStream_Exam {

	public static void main(String[] args) {
		// PrintWriter <-- FileOutputStream <-- File
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream(new File("file/pw_out.txt"));
			pw = new PrintWriter(fos);
			
			pw.write("안녕하세요");
			pw.write("점심시간 후 오후~~~\n");
			
			pw.print("지금 자바 공부중");
			pw.print("아직은 안졸린다.");
			pw.println();
			
			pw.println("조금 지나면 졸릴수도 있다~~");
			pw.println("끝나려면 4시간 남았다.");
			
			pw.printf("%10s %10s %10s %n" , "이제", "20	분", "남았다");
			pw.printf("%-50s", "18분 정도 남았습니다"); //기본이 우측정렬, -붙이면 좌측정렬
			pw.printf("%50s", "17분 정도 남았습니다"); //기본이 우측정렬, -붙이면 좌측정렬
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}

	}

}
