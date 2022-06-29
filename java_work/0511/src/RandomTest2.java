
public class RandomTest2 {

	public static void main(String[] args) {
		
		
		int[] lotto = new int[6]; // 숫자 6개 배열로 만들기 
	      lotto[0] = (int)(Math.random()*45)+1; // 1번째 랜덤 숫자 
	      for(int i=1; i<6; i++) {
	         int tmp = (int)(Math.random()*45)+1; // 랜덤  숫자 뽑기
	         int j; // 선언
	         for(j=0; j<i; j++) { // 반복문 
	            if(lotto[j]==tmp) break; // 만약에 j 가 tem랑 같으면 종료 
	         }
	         if(j==i) { // 만약에 j 랑 i사 같으면 
	            lotto[i] = tmp; // 로또 배열 i tmp  
	         }else { //아니라면
	            i--; // i 빼기;
	         }
	      }
	      for(int i:lotto) {
	         System.out.print(i+" ");
	      }
	}

}
