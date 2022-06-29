class Account {
	String id;
	String name;
	int balance;

	// Account 생성자(위치 중요)
	Account() {
	}

	Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	String info() {// this를 자동으로 생성
		return "계좌번호:" + id + ",이름:" + name + ",잔액:" + balance;
	}

	void deposit(int deposit) {
		this.balance += deposit;
	}

	void withdrow(int withdrow) {
		this.balance -= withdrow;

	}
}

public class ClassTest2 {

	public static void main(String[] args) {
		Account acc1 = new Account();
		acc1.id = "10001";
		acc1.name = "홍길동";
		acc1.balance = 100000;

		System.out.println(acc1.info());

		acc1.deposit(10000);
		System.out.println(acc1.info());

		acc1.withdrow(5000);
		System.out.println(acc1.info());

		/*
		 * 출력 결과 계좌번호: 10001, 이름 : 홍길동, 잔액:100000 계좌번호: 10001, 이름 : 홍길동, 잔액:110000 계좌번호:
		 * 10001, 이름 : 홍길동, 잔액:105000
		 */

		Account acc2 = new Account("10002", "고길동", 200000);
		// 생성자 만들기

	}

}
