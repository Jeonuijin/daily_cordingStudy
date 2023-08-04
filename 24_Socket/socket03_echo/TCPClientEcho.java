package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEcho {

	public static void main(String[] args) {
		// 클라이언트 : 쓰기, 읽기
		// 서버접속 후 메시지를 1번 보내고, -PrintWriter
		// 서버에서 보내온 메시지를 받기 - BufferedReader
		// PrintWriter <-- OutputStream
		// BufferedReader <-- InputStreamReader <-- InputStream
		//--------------------------------------------------
		//(추가) 보내는 메시지를 Scanner 사용 화면에서 직접 입력하여 처리
		//------------------------------------------------------
		
		System.out.println(">>> 클라이언트 시작~~~");
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.18.11", 100);
			System.out.println(">>> 서버 접속 성공~~~~");
			
			// 서버쪽으로 쓰고, 읽기 위한 객체 만들기
			
//			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//Scanner 사용해서 보낼 메세지 화면에서 입력처리
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				// 서버쪽으로 쓰기
				System.out.print("서버로 보낼 메세지를 입력하세요 : ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
//				System.out.println("보낸메세지> : " + msg);

				if (msg.equals("끝")) { 
					System.out.println(">>클라이언트 종료<<");
					break;
				}

				// 서버에서 보내온 메시지를 받기 - BufferedReader
				String st1 = br.readLine();
				System.out.println("서버로부터 보냈던 메세지 받기> : " + st1);

			}
			pw.close(); //변수를 값을 주고(null) 밖으로 빼서 try~catch문에다가 close처리를 할 수 있다.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//if구문 쓰는이유 : 값이 null인데 닫으려고하면 오류가 발생
				if (socket != null) socket.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
