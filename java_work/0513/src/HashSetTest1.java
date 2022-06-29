import java.util.HashSet;

public class HashSetTest1 {

	public static void main(String[] args) {
		Integer n =10; //boxing 
		int n2 = n; // unboxing
		
		HashSet hs = new HashSet();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(20); // 중복데이터 삽입되지 않음
		
		
		for(Object d : hs) {
			System.out.println(d);
		}
		
		HashSet<Person> hsp = new HashSet<>();
		hsp.add(new Person(10,"홍길동"));
		hsp.add(new Person(20,"김길동"));
		hsp.add(new Person(10,"박길동"));
		hsp.add(new Person(20,"홍길동"));
		hsp.add(new Person(10,"홍길동"));
		
		for(Person p :hsp) {
			System.out.println(p);
		}

	}

}
