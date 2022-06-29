
public class VariableTest {

	public static void main(String[] args) {
		char ch = 'A'; //캐릭터 한글자 
		String str = "A"; 
		int n = 100; // 정수의 기본 데이터타입 
		long l = 100L; // 숫자 뒤의 L은 소문자 대문자 상관 없음
		double d = 3.14; // 실수의 기본 데이터 타입 
		float f = 3.14F; // 숫자 뒤의  F는 소문자 대문자 상관없음 
		
		System.out.println(ch);
		
		boolean b = true; 
		
		int hex = 0X100; 
		System.out.println(hex);
		
		String s1 =""; // -> null 
		String s2="null"; // -> null 하지만 ,s1과 s2는 다름 

		String num1 = 7+7+"7"; // String 문자열 + 
		String num2 = "7"+7+7;
		
		System.out.println(num1);
		System.out.println(num2);
		
		int n1,n2,n3;
		n1=n2=n3=0; // '=' 의 결합 방식은 오른쪽에서 왼쪽(단항 연산자, 대입 연산자)
		
		// 증감 연산자 
		int i=0;
		//i++; // i=i+1
		//++i; // i=i+1 단독으로 쓰일 때에는 동일 
		
		int r;
		//r=++i; // r=1, i=1
		//r=i++; // r=0, i=0
		//System.out.println(i++);
		
		int x = 10;
		if(x>10 && (++i)>10) {
			
		}
		System.out.println(i); //and와 or연산 -> 앞에 값이 거짓이면 뒤에를 연산하지 않음
		
		byte b1 = 10;
		byte b2 = 20;
//		byte res = b1+b2; //에러
		byte res = (byte)(b1+b2);
		
		int m =10;
		m+=5; 
		m=+5; // m=m+5;
		m*=3+5; //m=m*(3+5);
		
		
		
		
	}

}
