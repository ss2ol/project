
public class RandomTest {

	public static void main(String[] args) {
		// double rand = Math.random();
		// 0 <= rand < 1
		// 0*45 <= rand*45 < 1*45
		// 0*45 <= Math.random()*45 < 1*45
		int[] ball = new int[45];
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

		// 스와핑 - 임시변수 만들어 넣어야함(temp)
		for (int i = 0; i < 1000; i++) {
			int rand1 = (int) (Math.random() * 45);
			int rand2 = (int) (Math.random() * 45);
			int temp = ball[rand1];
			ball[rand1] = ball[rand2];
			ball[rand2] = temp;
		}

		// 숫자 6개 출력
		for (int i = 0; i < 6; i++) {
			System.out.print(ball[i] + " ");
		}
	}

}
