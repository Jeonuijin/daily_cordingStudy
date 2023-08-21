
public class Ex11_while_exam {

	public static void main(String[] args) {
		// while 문 사용해서 처리
		// (실습) 문제1 : 1~10 까지의 합을 구하고 화면에 출력
		
		/*(실습) 문제 2 ---------
		 *****
		 *****
		 *****
		 */

		/*(실습) 문제 3 ----------
		 *
		 ** 
		 *** 
		 **** 
		 ----------------*/
		
		System.out.println("---- 문제 1 ----");
		
		int i = 0;
		int n = 0;
		
		while (i <= 10) {
			n = n + i;
			i++;
		}
		System.out.println("1~10 합계 : " + n);
		
		System.out.println("---- 문제 2 ----");
		
		
		int b = 1;
	
		while (b <= 3) {
			int a = 1;
			while (a <= 5) {
				System.out.print("*");
				a++;	
			}
			System.out.println();
			b++;
		}
		
		System.out.println("---- 문제 3 ----");
		
		int c = 1;
		int d = 1;
		
		while (c <= 4) {
			while (d <= c) {
				System.out.print("*");
				d++;
			}
			System.out.println();
			d = 1;
			c++;
		}
		
		
		
	}

}
