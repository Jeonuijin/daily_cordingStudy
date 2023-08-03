package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;



public class TCPClientByte {

	public static void main(String[] args) {
		// 클라이언트 : Socket 이용해서 서버에 접속(서버IP주소, 포트번호)
		Socket socket = null;
		try {
			System.out.println("==== 클라이언트 ===");
			//				   			IP주소, 포트번호
			socket = new Socket("127.0.0.1", 10000); // 127.0.0.1은 현재 접속중인 컴퓨터의 주소를 가르킨다.
			//socket = new Socket("localhost", 10000); // localhost는 현재 접속중인 컴퓨터의 주소를 가르킨다.
			//socket = new Socket("192.168.18.11", 10000);
			System.out.println(">>서버연결 성공 socket : " + socket);
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// OutputStream 이용해서 서버쪽으로 쓰기(출력)
//			System.out.println(">> 서버쪽으로 문자'A'보내기~~");
//			os.write('A');
		
			String msg = "ABC안녕하세요";
			System.out.println("서버로 보낸 메시지 : " + msg);
			byte[] buf = msg.getBytes();
			os.write(buf);
			
			os.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(">>클라이언트 종료");
	}

}
