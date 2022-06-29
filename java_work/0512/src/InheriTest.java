class Base{
	int bnum;
	Base() {}
	Base(int num){
		bnum =num;
	}
}

class Derived extends Base {
	int dnum;
	Derived() {}
	Derived(int bnum, int dnum){
		super(bnum);
		this.dnum=dnum;
	}
}


public class InheriTest {

	public static void main(String[] args) {
	}

}
