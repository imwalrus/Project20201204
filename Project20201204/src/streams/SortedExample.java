package streams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {

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
		String sql = "SELECT employee_id, last_name, salary FROM emp1";
		Statement pstmt = conn.createStatement();
		ResultSet rs = pstmt.executeQuery(sql);
		List<SortedEmp> list = new ArrayList<SortedEmp>();
		while (rs.next()) {
			SortedEmp emp = new SortedEmp();
			emp.setEmpId(rs.getInt("employee_id"));
			emp.seteName(rs.getString("last_name"));
			emp.setSalary(rs.getInt("salary"));
			list.add(emp);
		}

		//

		// salary 많은 순서대로 정렬
		List<SortedEmp> col = list.stream().sorted().collect(Collectors.toList());

		for (SortedEmp emp : col)
			System.out.println("사원번호: " + emp.getEmpId() + ", 이름: " + emp.geteName() + ", 급여: " + emp.getSalary());

	}
}
