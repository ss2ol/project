
public class DoubleArrayTest {

	public static void main(String[] args) {
		//이차원 배열
		int [][] score = new int [][] {
			{80,75,65}, //1 반 학생들의 국어 점수
			{70,85,90}, //2반 학생들의 국어 점수
			{85,90,70} //3반 학생들의 국어 점수 
		};
		
		// 각 반의 국어 점수와 전체 학생의 국어 평균 구하기 
		
		int kor = 0; 
		
		for(int i=0; i<score.length; i++) {
			int sum =0; 
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
			}
			System.out.println(i+1+"반 국어 점수 평균" + (double)sum/score[i].length);
			kor +=sum;
		}
		System.out.println("국어 점수 전체  평균" + (double)kor/(score.length*score[0].length));
		
	}

}
