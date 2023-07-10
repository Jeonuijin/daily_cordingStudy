
public class Ex07_for_exam {

	public static void main(String[] args) {
		/* 문제1 -----------------------
		***** : * 5번 + 줄바꿈
		****  : * 4번
		***	  : * 3번
		**	  : * 2번
		*	  : * 1번
		----------------------
		문제 2
		    * : 빈칸4 + * 1개 + 줄바꿈
		   ** : 빈칸3 + * 2개
	      *** : 	
		 ****
		*****            -->두덩어리로 구분해서 처리
		---------------------------
		문제 3
		***** : 빈칸0, * 5개, 줄바꿈
		 **** : 빈칸1, * 4개, 줄바꿈
		  ***
		   **
		    *
		-------------------------------
		문제 4
		1         : (1 + 빈칸1) + 줄바꿈
		1 2       : (1 + 빈칸1) (2 + 빈칸1) + 줄바꿈
		1 2 3     : 1 스페이스 2 스페이스 3
		1 2 3 4
		--------------------------------
		문제 5
		1
		2 3
		4 5 6
		7 8 9 10
		----------------------------------*/
		System.out.println("-------문제 1-------");
		
		for (int a = 1; a <= 5; a++) {
		for (int i = 5; i >= a; i--) {
			System.out.print("*");
		}System.out.println();
		}
	
	
		
		/*
		int starCnt = 5;
		for (int a = 1; a <= 5; a++) {
			for (int i = 1; i <= starCnt; i++) {
				System.out.print("*");
			}System.out.println();
			starCnt--;
		} 
		 */
		
		System.out.println("-------문제 2-------");
		
		for (int a = 1; a <= 5; a++) {
			for (int i = 5; i >= a; i--) {
				System.out.print(" ");		 
			}
			for (int b = 1; b <= a; b++) {
				System.out.print("*");
			}System.out.println();
		} 
		
		/*
		 int iCnt = 4;
		 int bCnt = 1;
		 
		 for (int a = 1; a <= 5; a++) {
		 	for (int i = 1; i <= iCnt; i++) {
				System.out.print(" ");		 
			}
			for (int b = 1; b <= bCnt; b++) {
				System.out.print("*");
			}System.out.println();
			
			iCnt--;
			bCnt++;
		} 
		*/
		
		System.out.println("-------문제 3-------");
		int spaceCnt = 0;
		int starCnt = 5;
		
		for (int i = 1; i <= 5; i++) {
			for (int b = 1; b <= spaceCnt; b++) {
				System.out.print(" ");
			}
			for (int a = 1; a <= starCnt; a++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt++;
			starCnt--;
		}
		
		System.out.println("-------문제 4-------");
		
		
	
		for (int i = 1; i <= 4; i++) {
			int num1 = 1;
			for (int a = 1; a <= i; a++) {
				System.out.print(num1 + " ");
				num1++;
			}
			System.out.println();
			
		}
		
		/*
		int a = 1;
		
		for (int b = 1; b <= 4; b++) {
			for (a = 1; a <= b; a++) {
				System.out.print(a);
				System.out.print(" ");
					}System.out.println();
			}
		*/
		
		System.out.println("-------문제 5-------");	
		
		int c = 1;
		
		for (int b = 1; b <= 4; b++) {
			for (int i = 1; i <= b; i++) {
				System.out.print(c++ + " ");
			}System.out.println();
			
		}
	
		
		
		
		
		
		/*int a = 1;
		
		for (int i = 1; i <= 4; i++) {
			for (a = 1; a <= i; a++) {
				System.out.print(a);
				System.out.print(" ");
			} System.out.println();
		}
		
	
	/*
	문제 4
	
		1         : (1 + 빈칸1) + 줄바꿈
		1 2       : (1 + 빈칸1) (2 + 빈칸1) + 줄바꿈
		1 2 3     : (1 + 빈칸1) (2 + 빈칸1) + 줄바꿈
		1 2 3 4
		 */
		
		
		
		
		
	}

}
