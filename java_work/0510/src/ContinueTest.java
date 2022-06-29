
public class ContinueTest {

	public static void main(String[] args) {
		int sum = 0; // 1+2+3+4+..
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0)
				continue;
			sum += i;
		}
		System.out.println(sum);
	}

}
