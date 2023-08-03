package com.mystudy.socket01_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClinetLine {

	public static void main(String[] args) throws UnknownHostException {
		// 서버접속 후 PrintWriter 사용해서 메시지 1번보내기(printwriter는 문자,byte 다 사용가능)
		// OutputStream --> Printwriter
		//----------------------------------------
		System.out.println(">>> 클라이언트 시작");
		Socket socket = null;
		
		System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">>> 서버 접속 시도~~");
		
		try {
			//1. 소켓(Socket) 생성 : 접속할 IP주소, 포트(port) 정보로 서버 접속
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			System.out.println(">>> 서버 접속 성공~~~~");
			
			//2. 소켓으로부터 입, 출력 객체 생성 - InputStream, OutputStream
			InputStream is = socket.getInputStream();
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//3. 전송(out)할 데이터가 있으면 쓰기(Write)
			String msg = "안녕하세요. 만나서 반갑습니다. 소켓통신 공부중~~~";
			pw.print(msg);
			pw.print("잘 되고 있나요?");
			pw.println("ㅎㅎㅎㅎ!!!!");
			
			pw.flush();
			
			//4. 읽을 데이터가 있으면 읽기(구현안함)
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} try {
			if (socket != null) { 
				socket.close();   //서버는 원래 잘 닫지 않음
				System.out.println(" close>Socket close 완료");
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
