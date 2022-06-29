class Person {
	int age;
	String name;

	Person() {// 생성자]
		this(0,"none");
//		this.age = 0;
//		this.name = "none";
	}

	Person(int age) { // 생성자
		this(age,"none");
//		this.age = age;
//		this.name = "none";
	}

	Person(String name) { // 생성자
		this(0,name);
//		this.age = 0;
//		this.name = name;
	}

	Person(int age, String name) { // 생성자
		this.age = age;
		this.name = name;
	}

	String info() {// this를 자동으로 생성
		return "이름:" + name + ",나이:" + age;
	}

	void setAge(int age) {
		this.age = age;
	}
}
// 클래스 안에 클래스 가능 

public class ClassTest1 {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(20,"허진솔");
		Person p3 = new Person(30);
		Person p4 = new Person("김진솔");
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
		System.out.println(p4.info());
		
//		p1.age = 10;
//		p1.name = "허진솔";
//		p1.setAge(15);
//		
//		Person p2 = new Person(20, "김진솔");
//		p2.age=20;
//		p2.name="김진솔";
//		p2.setAge(25);
//		
//		System.out.println(p1.info());
//		System.out.println(p2.info());
//		
//		p1 = p2;
//		System.out.println(p1.info());
//		System.out.println(p2.info());
//		
//		p1.name = "이진솔";
//		System.out.println(p1.info());
//		System.out.println(p2.info());
	}

}
