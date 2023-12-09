package di_annotation;

import org.springframework.stereotype.Component;

public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("--->> AppleSpeaker() 객체생성");
	}
	
	public void volumnUp() {
		System.out.println(">> AppleSpeaker - 소리크게");
	}
	public void volumnDown() {
		System.out.println(">> AppleSpeaker - 소리작게");
	}
}
