package polymorphism03;

import java.util.Arrays;

public class TVUser {
	
	public static void main(String[] args) {
		System.out.println("args : " + Arrays.deepToString(args));
		BeanFactory factory = new BeanFactory();
		
		//SamsungTV, LgTV 사용
		//TV tv = (TV)factory.getBean("samsung");
		
		TV tv = (TV)factory.getBean(args[0]);
		System.out.println("tv : " + tv);
		tv.powerOn();
		tv.VolumeUp();
		tv.VolumeDown();
		tv.powerOff();
	}
}
