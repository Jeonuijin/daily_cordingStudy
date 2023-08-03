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
			System.out.println("IP주소값 : " + InetAddress.getLocalHost());
			
			Socket socket = server.accept();
			System.out.println("클라이언트와 접속 : " + socket);
			
			// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);

			while (true) {
				String str = br.readLine();
				System.out.println("2. [서버]받은메시지출력 : " + str);
				if (str.equals("끝")) break;

				// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWritter
				System.out.println("3. ==[서버]받은메세지 클라이언트에게 다시 보내기==");

				pw.println(str);
				pw.flush();
			}

			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (server != null) server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
