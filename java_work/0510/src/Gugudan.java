
public class Gugudan {

	public static void main(String[] args) {
		//구구단 -2단
		//중첩문을 이용해서 9단까지 
		for(int i=1; i<=9;i++) {
			for(int dan=2;dan<=9; dan++) {
			System.out.print(dan+"X"+i+"="+ dan*i + "\t");
		}
		System.out.println();
		}

	}

}
