package com.mystudy.net_multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// 서버쪽으로 메시지 전송만~~~
public class TCPClientMulti {

	public static void main(String[] args) {
		System.out.println(">>> 클라이언트 시작 ~~~ ");
		Socket socket = null;
		
		PrintWriter pw = null;
		try {
			socket = new Socket("localhost", 10000);
			System.out.println(">> 서버 접속 완료");
			
			pw = new PrintWriter(socket.getOutputStream());
			//Scanner 사용해서 보낼 메시지 화면에서 입력처리
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				// 쓰기 --------------
				System.out.print("전송 메시지 입력 : ");
				String msg = scan.nextLine();
				
				pw.println(msg); // 서버쪽으로 출력
				pw.flush(); //버퍼에 있는 데이터를 강제로 출력(사용)
				
				if ("exit".equalsIgnoreCase(msg)) {
					System.out.println("::: 메시지 전송을 중단하고 종료합니다");
					break;
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {}
		}
		
		System.out.println(">> 클라이언트 종료");
	}

}
