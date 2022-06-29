import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person(30, "홍길동"));
		ts.add(new Person(20, "박길동"));
		ts.add(new Person(10, "고길동"));

		TreeSet<Person> tsn = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		tsn.add(new Person(30, "홍길동"));
		tsn.add(new Person(20, "박길동"));
		tsn.add(new Person(10, "고길동"));
		for (Person p : ts) {
			System.out.println(p);
		}
	}

}
