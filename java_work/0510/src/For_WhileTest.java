
public class For_WhileTest {

	public static void main(String[] args) {
		/*
		int sum = 0;
		int i;

		for (i = 1;; i++) {
			sum += i;
			if (sum >= 100)
				break;
		}
		System.out.println(i + "," + sum);
		*/

		int sum = 0;
		int i=1 ;
		
		while(true) {
			sum += i;
			if(sum>=100)break;
			i++;
		}
		System.out.println(i+","+ sum);
		
		
	}

}
