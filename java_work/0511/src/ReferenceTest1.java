class Number{
	int n;

}

public class ReferenceTest1 {
	public static void func(int d) {
		System.out.println(d);//10
		d++; 
		System.out.println(d);//11
	}
	public static void main(String[] args) {
		Number num = new Number();
		num.n=10;
		func(num.n);
		System.out.println(num.n);//10
		
	}

}
