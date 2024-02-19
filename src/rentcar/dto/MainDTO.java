package rentcar.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MainDTO {
	private MainDTO() {
		// TODO Auto-generated constructor stub
	}

	public static MainDTO instance;

	public static MainDTO getInstance() {
		if (MainDTO.instance == null) {
			MainDTO.instance = new MainDTO();
		}
		return MainDTO.instance;
	}

	private Connection conn;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Connection getConnect() {
		String url = "jdbc:mysql://localhost:3306/rentcardb01?charaterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String pasword = "1111";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pasword);
			System.out.println(conn);
		} catch (Exception e) {
			System.out.println("연동실패");
		}
		return conn;
	}
}
