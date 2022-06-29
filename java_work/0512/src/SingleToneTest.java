class OneArray{
	int [] arry =new int [100];
	private OneArray() { // 내부에서 생성 가능 
	}
	static OneArray oneArray;
	static OneArray getArrayRef() { //메서드가 인스턴스- 외부에서 생성하지 않고 쓰려면 =static
		if(oneArray == null) {
			oneArray = new OneArray();
		}
		return oneArray;
	}
	
	void setData(int idx, int data) {
		arry[idx] = data;
	}
	int getData(int idx) {
		return arry[idx];
	}
}
public class SingleToneTest {

	public static void main(String[] args) {
		//OneArray oa = new OneArray(); // private 생성자 생서 불가
		OneArray oa1 =OneArray.getArrayRef();
		OneArray oa2 =OneArray.getArrayRef();
		oa1.setData(0,100);
		System.out.println(oa2.getData(0));
	}

}
