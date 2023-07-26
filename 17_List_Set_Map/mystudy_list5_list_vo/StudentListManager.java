package com.mystudy_list5_list_vo;

import java.util.ArrayList;
import java.util.List;

/*
성적처리를 위한 관리용 클래스를 생성 CRUD 기능을 구현하고 확인하시오
(학생 정보를 List에 저장하고 관리하되 이름은 중복되지 않는다)  
■ 클래스명 : StudentListManager
■ 속성(필드변수) : StudentVO 저장을 위한 List
■ 기능(메소드)
  - select : StudentVO 타입 데이터를 전달받아 동일한 이름 데이터를 찾아서 리턴
  - select : 이름(String)을 전달받아 동일한 이름 데이터 찾아서 리턴
  - selectAll : 전체 데이터 리턴
  - insert : StudentVO 타입 데이터를 전달받아 List에 추가
  - update : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 수정
  - update : 이름(String)을 전달받아 동일한 이름 데이터 수정
  - delete : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 삭제
  - delete : 이름(String)을 전달받아 동일한 이름 데이터 삭제
*/



public class StudentListManager {
	
	private List<StudentVO> list = new ArrayList<StudentVO>();

	StudentVO vo = new StudentVO("홍길동", 90, 100, 85);

////	public List<StudentVO> select(StudentVO vo) {
////		if (this.vo == vo)
////			return vo;
//		
//	
//		
//		
//		
//	}
	//list.size() => arraylist 객체의 갯수
	//  - select : StudentVO 타입 데이터를 전달받아 동일한 이름 데이터를 찾아서 리턴
	public StudentVO select(String searchName) {
		for (int i = 0; i < list.size(); i++) {
			if (searchName.equals(list.get(i).getName())) {
				return list.get(i);
			}
				
		}
		return null;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentListManager other = (StudentListManager) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}


	
	
	
}
