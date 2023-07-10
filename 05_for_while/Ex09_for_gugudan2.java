
public class Ex09_for_gugudan2 {

	public static void main(String[] args) {
		/* 구구단 2~9단 출력
		 2*1=2     3*1=3     ... 9*1=9
		 2*2=4     3*2=6     ... 9*2=18
		 2*3=6     3*3=9     ... 9*3=27
		 ...
		 2*9=18    3*9=27    ... 9*9=81
	
		 ===============================*/
		
		for (int a = 1; a <= 9; a++) {
			for (int i = 2; i <= 9; i++) {
				System.out.print(i + "*" + a + "=" + i*a + "\t");
			} 
			System.out.println();
		}
		
		System.out.println("--------------------------------");
		
	
		int n = 2;
		
		for (int b = 1; b <= 8; b++) {
			for (int a = 1; a <= 9; a++) {
				System.out.print(n + "*" + a + "=" + n * a + "\t");
			}
			System.out.println();
			n++;
		}
		
		
	}

}
