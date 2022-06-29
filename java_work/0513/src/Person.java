import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable{
		int age;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		String name;

		Person() {// 생성자]
			this(0,"none");
//			this.age = 0;
//			this.name = "none";
		}

		Person(int age) { // 생성자
			this(age,"none");
//			this.age = age;
//			this.name = "none";
		}

		Person(String name) { // 생성자
			this(0,name);
//			this.age = 0;
//			this.name = name;
		}

		Person(int age, String name) { // 생성자
			this.age = age;
			this.name = name;
		}

		public String toString() {// this를 자동으로 생성
			return "이름:" + name + ",나이:" + age;
		}

		void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Person == false)
				return false;
			Person p = (Person)obj;
		return name.equals(p.getName()) && age == p.getAge();
		}
		
		@Override
		public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + age;
		}

		@Override
		public int compareTo(Person o) {
			return age-o.age;
		}

		
	
	}

