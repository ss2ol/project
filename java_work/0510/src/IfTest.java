
public class IfTest {

	public static void main(String[] args) {
		int kor=94, math=88, eng=87;
		double avg =(kor+math+eng)/3.0;
		avg=(int)Math.round(avg*100)/100d;
		char grade;
		if(avg>=90) {
			grade='A';
		}else if(avg>=80) {
			grade='B';
		}else if(avg>=70) {
			grade='C';
		}else if(avg>=60) {
			grade='D';
		}else {
			grade='F';
		}
		System.out.println("평균:" + avg+", 학점:"+ grade);
	}

}
