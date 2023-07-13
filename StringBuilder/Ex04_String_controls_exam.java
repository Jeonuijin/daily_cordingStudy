package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex04_String_controls_exam {

	public static void main(String[] args) {
		/* 문자열 다루기
		0.문자열 데이터
		  String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		  String str2 = "    TOM   을지문덕 김유신 연개소문";
		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		     (String split() 또는 StringTokenizer 클래스 사용)
		      예) 홍길동 이순신 이순신 Tom 홍길동 TOM... ///화면출력만, 데이터x 중간에 빈칸 넣어서 출력
		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장  
		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...  //apend사용, 데이터가 StringBuilder에 있어야함 
		4. 배열데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍,이,이,T,홍,T,을... 
		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		      예) 인덱스번호:을지문덕
		********************************/ 

		//0.문자열 데이터
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		
		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println("sb : " + sb);
		
		//2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
	     //(String split() 또는 StringTokenizer 클래스 사용)
	      //예) 홍길동 이순신 이순신 Tom 홍길동 TOM... ///화면출력만, 데이터x 중간에 빈칸 넣어서 출력
		//String a = sb.toString();
		//String[] names = a.split(" ");
		String[] names = sb.toString().split(" ");
		
		//저장된 배열 데이터 확인
		
		for (int i = 0; i < names.length; i++) {
			if (!"".equals(names[i])) {	
				System.out.print(names[i] + " ");	
			}
		}
		System.out.println();
		
		//---------------------------------------------
		System.out.println("--- length() > 0 사용---");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && names[i].trim().length()>0) {
				System.out.print(names[i] + " ");
			}
		}
		System.out.println();
		
		
		//2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장

		//3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
	      //예) 홍길동,이순신,이순신,Tom,홍길동,TOM...  //apend사용, 데이터가 StringBuilder에 있어야함 
		
		StringBuilder names1 = new StringBuilder();
		
		for (int i = 0; i < names.length; i++) {
			if (!"".equals(names[i])) {	
				if (i == 0 ) {
					names1.append(names[i]);
				}else {
					names1.append(",").append(names[i]);
				}
					
			}
		}
		System.out.println("names1 : " + names1.toString());
		
		System.out.println("===== 문제4 =====");
		//4. 배열데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
	      //예) 홍,이,이,T,홍,T,을... 
		StringBuilder sb4 = new StringBuilder();
		
		for (int i = 0; i < names.length; i++) {
			if (!"".equals(names[i])) {	
				if (i == 0 ) {
					sb4.append(names[i].charAt(0));
				}else {
					sb4.append(",").append(names[i].charAt(0));
				}
					
			}
		}
		//sb4.delete(sb4.length() - 1, sb4.length());
		sb4.deleteCharAt(sb4.length() - 1);
		System.out.println("sb4 : " + sb4);
		
		System.out.println("========= StringTokenizer 사용 ==========");
		System.out.println("StringBuilder sb : " + sb);
		StringTokenizer tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수 : " + tokens.countTokens());
		System.out.println("------");
		
		while (tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
		
		System.out.println("------");
		System.out.println("토큰갯수 : " + tokens.countTokens());
		System.out.println("=========");
		
		tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수 : " + tokens.countTokens());
		
		String[] names2 = new String[tokens.countTokens()];
		System.out.println("names2.length : " +names2.length);
		System.out.println(Arrays.toString(names2));
		
		int idx = 0;
		while (tokens.hasMoreTokens()) {
			// 배열에 저장
			names2[idx++] = tokens.nextToken();
		}
		System.out.println(Arrays.toString(names2));
		
		
	}
}


