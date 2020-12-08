package streams;

public class SortedEmp implements Comparable<SortedEmp> {
	private int empId;
	private String eName;
	private int salary;

	public SortedEmp() {

	}

	public SortedEmp(int empId, String eName, int salary) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public String geteName() {
		return eName;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(SortedEmp o) {
		return o.salary - this.salary;
	}
}