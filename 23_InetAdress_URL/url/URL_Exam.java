package com.mystudy.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// 프로토콜://호스트(서버):포트번호/경로(패스)?질의(query)
		// https://n.news.naver.com/article/662/0000025656?cds=news_media_pc&type=editn
		
		URL url = new URL("http","mystudy.com",8080,
				"/aaa/bbb/index.jsp?id=hong&password=1234#content");
		//http://mystudy.com:9090/aaa/bbb/index.jsp?id=hong&password=1234#content
		System.out.println("url : " + url);
		//protocol = 규약(약속) getProtocol() ->어떤 약속을 썼느냐
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort(); //포트번호로 컴퓨터에 있는 다양한 서비스를 찾아가 쓸수있다.
		int defaultPort = url.getDefaultPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트번호(defaultPort) : " + defaultPort);
		System.out.println("경로-패스(path) : " + path);
		System.out.println("쿼리-질문(query) : " + query);
		System.out.println("참조(ref) : " + ref);
	
		System.out.println("-------------------");
		url = new URL("https://n.news.naver.com/article/662/0000025656?cds=news_media_pc&type=editn");
		System.out.println("url : " + url);
		
		protocol = url.getProtocol();
		host = url.getHost();
		port = url.getPort(); //포트번호로 컴퓨터에 있는 다양한 서비스를 찾아가 쓸수있다.
		defaultPort = url.getDefaultPort();
		path = url.getPath();
		query = url.getQuery();
		ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트번호(port) : " + port); //포트번호가 없으면 -1으로 출력된다.
		System.out.println("기본포트번호(defaultPort) : " + defaultPort); //포트번호가 따로 없으면 기본포트번호로 설정된다.
		System.out.println("경로-패스(path) : " + path);
		System.out.println("쿼리-질문(query) : " + query);
		System.out.println("참조(ref) : " + ref);
	}

}
