package streams.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
		return conn;
	}

//
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String sql = "SELECT employee_id, last_name, email, salary, department_id FROM emp1";
		Statement pstmt = conn.createStatement();
		ResultSet rs = pstmt.executeQuery(sql);
		List<EmployeeList> list = new ArrayList<EmployeeList>();
		while (rs.next()) {
			EmployeeList emp = new EmployeeList();
			emp.setEmpId(rs.getInt("employee_id"));
			emp.seteName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setSalary(rs.getInt("salary"));
			emp.setDept(rs.getInt("department_id"));
			list.add(emp);
		}

		// 1) 급여가 10000이상인 사원 출력 (사원번호, 이름, 메일, 급여)
		Stream<EmployeeList> stream = list.stream();
		stream.filter((t) -> t.getSalary() >= 10000) //
				.forEach((t) -> t.showEmpInfo());
		System.out.println("========================================");

		// 2) 선적부서(부서번호 50) : 급여합계 (평균)
		int sum = list.stream() //
				.filter(m -> m.getDept() == 50) //
				.mapToInt((s) -> s.getSalary()) //
				.sum(); //
		System.out.println("합계: " + sum);

		double avg = list.stream() // 
				.filter(m -> m.getDept() == 50) //
				.mapToInt((s) -> s.getSalary()) //
				.average().getAsDouble(); //
		System.out.println("평균: " + avg);
		System.out.println("========================================");

		// 3) 3. 급여 (5000~10000)인 사원 출력 (사원번호, 이름, 메일, 급여)
		list.stream()
				.filter((t) -> t.getSalary() >= 5000) //
				.filter((t) -> t.getSalary() <= 10000) //
				.forEach((t) -> t.showEmpInfo());

	}
}
