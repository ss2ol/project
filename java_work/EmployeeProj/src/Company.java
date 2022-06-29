import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	public static Employee[] employees = new Employee[1000];
	public static int cnt;

	public void addEmployee(Employee employee) {
		employees[cnt++] = employee;
	}

	public void allEmpInfo() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(employees[i]);
		}
	}

	public int allTotalPay() {
		int total = 0;
		for (int i = 0; i < cnt; i++) {
			total += employees[i].getPay();
		}

		return total;
	}
	
	public void regBusinessTrip(IBusinessTrip emp, int day) {
		emp.goBusinessTrip(day);
	}

	public static void main(String[] args) {
		Company com = new Company();
		Permanent emp1 = new Permanent("10001", "홍길동", 5000000);
		Sales emp2 = new Sales("10002", "김길동", 3000000, 3000000);
		PartTime emp3 = new PartTime("10003", "고길동", 160, 50000);
		com.addEmployee(emp1);
		com.addEmployee(emp2);
		com.addEmployee(emp3);
		
		
		//com.regBusinessTrip(emp1,2); // 에러
		com.regBusinessTrip(emp2,2); 
		com.regBusinessTrip(emp3,3); 

		com.allEmpInfo();
		System.out.println("총 급여액 : " + com.allTotalPay());
	}

}

/*
 * 출력결과 사번 : 10001, 이름 : 홍길동, 급여 : 5000000 사번 : 10002, 이름 : 김길동, 급여 : 6000000 사번
 * : 10003, 이름 : 고길동, 급여 : 8000000 총 급여액 : 19000000
 */