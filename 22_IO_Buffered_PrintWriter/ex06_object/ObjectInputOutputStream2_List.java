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

		ArrayList<StudentVO> list = new ArrayList<>();
		list.add(stu);
		list.add(stu2);
		
		// 파일에 List를 쓰고, 파일에서 List 읽어와서 담긴 데이터 화면 출력
		System.out.println("=== List 파일에 출력(Output) =======");
		
		File file = new File("file/object_io_list.data");
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		System.out.println("==== 파일에서 List 읽기(Input) ====");
		try {
			//List에 있는 VO 가져다 화면출력
			ois = new ObjectInputStream(new FileInputStream(file));
			ArrayList<StudentVO> arIn = (ArrayList<StudentVO>)ois.readObject();
		
			for(StudentVO st : arIn) {
				System.out.println(st.getName() + " " + st.getKor() + " " + st.getEng() + " " 
						+ st.getAvg() + " " + st.getTot());
			}
			System.out.println("--------------------------------");
			
			for (int i = 0; i < arIn.size(); i++) {
				StudentVO st = arIn.get(i);
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
		
		FileOutputStream fos = null;
		try {
			//List를 파일에 출력 
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			// 파일에 List 쓰기
			oos.writeObject(list);
			
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
