
public class Ex08_for_gugudan {

	public static void main(String[] args) {
		/* 구구단 중 2단 출력
		 2*1=2
		 2*2=4
		 2*3=6
		 ...
		 2*9=18
		 ==============================*/
		
		int a = 2;
		System.out.println("=====2 ~ 9단 출력=====");
		System.out.println();
		
		for (int b = 1; b <= 8; b++) {
			System.out.println("---- <"+ a + "단> ----");
			for (int i = 1; i <= 9; i++) {
			System.out.println(a + " * " + i + " = " + (a * i));
			}System.out.println();
			a++;
			}
	
		System.out.println("****2 ~ 9단 출력****");
		
		for (a = 2; a <= 9; a++) {
			System.out.println("---- <"+ a + "단> ----");
			for (int i = 1; i <= 9; i++) {
			System.out.println(a + " * " + i + " = " + (a * i));
			}System.out.println();
		}
		
	
	
	
	
	}

}
