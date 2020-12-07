package streams.test;

public class EmployeeList {
	private int empId;
	private String eName;
	private String email;
	private int salary;
	private int dept;

	public EmployeeList() {
	}

	public EmployeeList(int empId, String eName, String email, int salary, int dept) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.email = email;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public void showEmpInfo() {
		System.out.println("사원번호: " + empId + ", 이름: " + eName + ", 메일: " + email + ", 급여: " + salary);
	}
	
}
