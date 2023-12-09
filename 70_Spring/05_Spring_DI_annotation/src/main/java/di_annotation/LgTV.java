package di_annotation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Speaker 추가하고 @Component, @Autowired, @Qualifier 추가해서 설정
@Component("LgTV") //명칭을 따로 주지 않으면 클래스명 첫글자 소문자로 적용됨
public class LgTV implements TV {
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public LgTV() {
		System.out.println(">> LgTV() 객체 생성");
	}
	@Autowired
	public LgTV(@Qualifier("sony") Speaker speaker) {
		this.speaker = speaker;
		
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~~");
		speaker.volumnUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~~");
		speaker.volumnDown();
	}
}
