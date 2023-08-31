
public class Ex03_AND_OF_NOT {

	public static void main(String[] args) {
		// 논리연산자 : && (AND), || (OR), ! (NOT)
		// 논리연산자 : (&&,||,!)의 좌, 우에는 true, false값만 올 수 있다.
		System.out.println("---- && (AND) -----");
		System.out.println("true && true : " + (true && true));
		System.out.println("true && false : " + (true && false));
		System.out.println("false && true : " + (false && true));
		System.out.println("false && false : " + (false && false));
		System.out.println("----------------------------");
		
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println(bool1 + " && " + bool2 + " : " + (bool1 && bool2));
		System.out.println("=======================================");
		
		int num1 = 10;
		int num2 = 20;
		// (num1 < num2) && bool1 : ???
		boolean result = (num1 < num2) && bool1;
		System.out.println(num1 + " < " + num2 + " && " + bool1 + " : " + result);
		
		System.out.println("--------|| (OR) ---------");
		System.out.println("false || true : " + (true || true));
		
		result = (num1 < num2) || bool1;
		System.out.println(num1 + " < " + num2 + " || " + bool1 + " : " + result);
		
		System.out.println("------ ! (NOT) -------");
		System.out.println("!true : " + !true);
		result = !(num1 < num2 || bool1);
		System.out.println("num1 < num2 || bool1 : " + result);
		
	}

}
