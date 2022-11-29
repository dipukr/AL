import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	private static void dumpUser(ResultSet rs) throws Exception {
		System.out.printf("%-5d%-10s%-20s%-10s\n",
			rs.getInt("id"),
			rs.getString("name"),
			rs.getString("email"),
			rs.getString("password"));
	}

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/userdb";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "root", "root");
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from users");
		while (rs.next()) dumpUser(rs);
	}
}
