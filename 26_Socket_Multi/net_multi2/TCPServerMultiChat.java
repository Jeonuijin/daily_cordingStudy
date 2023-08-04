package com.mystudy.net_multi2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;

// === 멀티채팅 서버측 기능 ===
// 다중 접속을 처리할 수 있는 서버(서버에서 읽기만 - 독립적인 쓰레드)
// 읽기전용쓰레드 : 접속자가 보낸 메시지를 언제든지 읽을 수 있어야함
// 접속자 명단 가지고 있기
// 받은(읽은) 메시지를 접속자 모두에게 전송하는 기능
public class TCPServerMultiChat {
	private HashMap<String, DataOutputStream> clients;

	
	
	public static void main(String[] args) {
		System.out.println("==== main() 시작 =======");
		new TCPServerMultiChat().serverStart();
		System.out.println("==== main() 끝 =======");

	}
	
	public TCPServerMultiChat() {
		clients = new HashMap<String, DataOutputStream>();
		serverStart();
	}

	private void serverStart() {
		// 서버소켓을 만들고, 클라이언트 접속처리를 반복한다
		ServerSocket server = null;
		
		try {
			System.out.println(">> 서버소켓 객체 생성");
			server = new ServerSocket(10000);
			
			while (true) {
				System.out.println(">> 접속 대기중~~~ " 
						+ InetAddress.getLocalHost().getHostAddress()
						+ ":" + server.getLocalPort());
				
				Socket socket = server.accept();
				System.out.println("사용자가 접속되었습니다 - " 
						+ socket.getRemoteSocketAddress());
				
				// 접속된 클라이언트(사용자)에 대한 처리 - 쓰레드 생성(읽기전용)
				System.out.println(":: 접속유저 읽기 전용 쓰레드 만들었다~~");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); //쓰레드로 동작시키기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ServerReceiver : 클라이언트에서 보내온 메시지 수신 전용
	private class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		String name;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 생성될때 : 필드에  사용자(clients) 추가
			// 종료될 때 : 필드에 사용자 명단(clients)에서 제외(삭제) 처리 -->아직 안함(집에서해보기)
			// 클라이언트에서 보내온 메시지를 읽어서 화면(콘솔)에 표시
			System.out.println(">>> 읽기 전용 쓰레드 시작 -----");

			try {
				//사용자 등록작업
				name = socket.getInetAddress().getHostAddress(); //접속한 사용자 IP주소를 name에 저장
				clients.put(name, out);
				
				while (true) {
					String msg = in.readUTF();
					if (msg == null || "exit".equalsIgnoreCase(msg)) {
						break;
					}
					System.out.println(name + ">> " + msg);
					
					//접속자 전원에게 메세지 일괄 전송하기
				}
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			} finally {
				System.out.println(socket.getInetAddress().getHostAddress() + "> 클라이언트 종료");
				
			}
			
			
		}
		//접속자 전원에게 메세지 일괄 전송하기
		private void sendToAll(String msg) {
			//-->아직 안함(집에서해보기)
		}
	}
	
} //end class









