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
		
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.18.12", 100);
			System.out.println(">>> 서버 접속 성공~~~~");
			
			// 서버접속 후 메시지를 1번 보내고, -PrintWriter
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			Scanner sc = new Scanner(System.in);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.println("1. [클라이언트] 서버로 보낼 메세지를 입력하세요 : ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();

				if (msg.equals("끝")) { 
					System.out.println(">>종료<<");
					break;
				}

				// 서버에서 보내온 메시지를 받기 - BufferedReader

				String st1 = br.readLine();
				System.out.println("4. [클라이언트]서버로부터 보냈던 메세지 받기 : " + st1);

			}
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
