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

public class TCPServerEcho {

	public static void main(String[] args) {
		//서버쪽 : 읽고, 쓰기
		// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader
		// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWritter
		// BufferedReader <-- InputStreamReader <-- InputStream
		// PrintWriter <-- OutputStream
		//---------------------------------------------------
		
		ServerSocket server = null;
		
		try {
			//클라이언트와 접속하기
			server = new ServerSocket(100);
			System.out.println(">> 서버시작~~~ 접속대기중~~~");
			System.out.println("IP주소값 : " + InetAddress.getLocalHost());
			
			Socket socket = server.accept();
			System.out.println("클라이언트와 접속됨");
			System.out.println(":: 접속정보 : " + socket.getInetAddress());
			
			// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader
			
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
			// 변수가 따로 필요 없는경우 한번에 넣어서 처리 가능
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			

			while (true) {
				String str = br.readLine();
				if (str.equals("끝")) {
					System.out.println(">>서버종료<<");
					break;
				}
				System.out.println("::메세지 읽기~");
				System.out.println("받은메시지출력> : " + str);
	
				// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWritter
				System.out.println("==받은메세지 클라이언트에게 다시 보내기==");
				
				pw.println(str);
				System.out.println("다시보낸 메세지> : " + str);
				
				pw.flush(); // 버퍼에 있는 데이터 전송
			}

			pw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (server != null) server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
}
