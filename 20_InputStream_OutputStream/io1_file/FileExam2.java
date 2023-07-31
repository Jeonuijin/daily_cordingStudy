package com.mystudy.io1_file;

import java.io.File;

public class FileExam2 {

	public static void main(String[] args) {
		// 파일명 : temp.txt - 파일명, 확장자(명)
		File file1 = new File("temp.txt");
		// File 객체 생성은 파일의 존재여부와 관계없이 객체 생성 가능.
		System.out.println(file1);
	}

}
