package polymorphism02;

public class LgTV implements TV{
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
		
	}
	@Override
	public void VolumeUp() {
		System.out.println("LgTV - 소리크게");
		
	}
	@Override
	public void VolumeDown() {
		System.out.println("LgTV - 소리작게");
		
	}
}
