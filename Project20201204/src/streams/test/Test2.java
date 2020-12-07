package streams.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;

public class Test2 {
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

		// 4) 40번 부서사원 평균 급여 출력. (40은 없는 부서)
		OptionalDouble avg = list.stream() //
				.filter(m -> m.getDept() == 50) //
				.mapToInt((s) -> s.getSalary()) //
				.average(); //
		System.out.println("평균: " + avg.orElse(0.0));
		
//		avg.ifPresent(new DoubleConsumer() {
//			@Override
//			public void accept(double value) {
//				System.out.println("평균: " + avg.getAsDouble());
//			}
//		});
	}
}
