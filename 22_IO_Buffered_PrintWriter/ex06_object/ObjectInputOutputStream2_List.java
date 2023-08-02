package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ObjectInputOutputStream2_List {

	public static void main(String[] args) {
		// StudentVO 객체들을 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO 데이터를 화면 출력
		// 사용할 파일명 : file/object_io_list.data
		//-------------------------------------------------
		// VO 데이터 생성 --> List에 저장 ---> List를 파일에 출력
		// 파일에서 List 읽기 ---> List에 있는 VO 가져다 화면출력
		
		StudentVO stu = new StudentVO("홍길동", 100, 90, 80);
		StudentVO stu2 = new StudentVO("김유신", 95, 85, 75);

		ArrayList<StudentVO> ar = new ArrayList<>();
		ar.add(stu);
		ar.add(stu2);
		
		ar.spliterator();
		
		File file = new File("file/object_io_list.data");
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			//List에 있는 VO 가져다 화면출력
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList arIn = (ArrayList)ois.readObject();
			
			for(StudentVO st : ar) {
				System.out.println(st.getName() + " " + st.getKor() + " " + st.getEng() + " " 
						+ st.getAvg() + " " + st.getTot());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			//List를 파일에 출력 
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(ar);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
