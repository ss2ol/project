
public class SwitchTest {

	public static void main(String[] args) {
		int kor = 94, math = 88, eng = 87;
		double avg = (kor + math + eng) / 3.0;
		avg = (int) Math.round(avg * 100) / 100d;
		String grade = "";
		switch ((int) (avg / 10)) {
		case 10: 
		case 9:  // 바로 이러지는 경우 10,9 같이 실행 
			grade = "A";
			break; // 명령어가 있을 때에는 break 있어야함 
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.println("평균:" + avg + ", 학점:" + grade);
	}

}
