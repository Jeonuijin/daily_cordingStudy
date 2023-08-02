package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputStreamReader_Exam2 {

	public static void main(String[] args) {
		// OutputStreamWriter 객체 생성해서 텍스트 출력해보세요~~
		// Hello Java~~ 안녕!!
		File file = new File("file/test_osw.txt");
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;

		try {
			fos = new FileOutputStream(file);
			fos.write('A');
			fos.write('대');
			
			osw = new OutputStreamWriter(fos);
			osw.write("Hello Java!!\n");
			osw.write("안녕하세요");

			bw = new BufferedWriter(osw);			
			bw.newLine();
			bw.write("반갑습니다");
			
			bw.flush();
			fos.flush();
		
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(osw != null) osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
