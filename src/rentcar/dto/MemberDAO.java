package rentcar.dto;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rentcar.vo.Member;

public class MemberDAO {

	public MemberDAO() {
		
	}
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;
	
	public ArrayList<Member> getMemberList() {
		ArrayList<Member> list = new ArrayList<Member>();

		String sql = "select * from member";
		conn = MainDTO.getInstance().getConnect();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				Member m = new Member(num, id, pass, name, age, email, phone,null,null);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}
	
	public boolean updateMemberContent(String name, String email, String age, String phone, String num) {
		Member m = null;
		String sql = "update member set name=?, email=?, age=?,phone=? where num =?";
		
		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3,Integer.parseInt(age));
			ps.setString(4, phone);
			ps.setString(5, num);
			System.out.println(ps.toString());
			int cnt = ps.executeUpdate();
			System.out.println(cnt);
					
			if(cnt == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}
	
	public boolean deleteMember(String id) {
		Member m = null;
		String sql = "delete from member where id =?";

		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int cnt = ps.executeUpdate();
					
			if(cnt == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}
	public boolean checkId(String id) {
		boolean m = false;
		String sql = "select * from member where id =?";

		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(!rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return m;
	}
	public Member memberContent(String n) {
		Member m = null;
		String sql = "select * from member where num =?";

		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, n);
			rs = ps.executeQuery();
			if(!rs.next()) {
				return null;
			}else {
				int num = rs.getInt("no");
				String id = rs.getString("id");
				String pass = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String sFileName = rs.getString("sFileName");
				String oFileName = rs.getString("oFileName");
				m = new Member(num, id, pass, name, age, email, phone,sFileName,oFileName);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return m;
	}
	public boolean insert(String id, String pw, String email ,String tel, String hobby
			,  String job,String age, String info) {
		String sql = "insert into member(id,pw,email,tel,hobby,job,age,info) values(?,?,?,?,?,?,?,?);";

		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, email);
			ps.setString(4, tel);
			ps.setString(5, hobby);
			ps.setString(6, job);
			ps.setString(7, age);
			ps.setString(8, info);
			int cnt = ps.executeUpdate();
			if(cnt == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}
	public boolean checkLogin(String id,String pw) {
		String sql = "select * from member where id =? and pw =?";
		
		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return false;
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
