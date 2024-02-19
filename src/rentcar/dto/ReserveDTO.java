package rentcar.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rentcar.vo.Carreserve;
import rentcar.vo.Member;

public class ReserveDTO {
	public ReserveDTO() {

	}

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;
	
	
	public boolean insert(String no,String pay,String id, String qty,
			String startDate,String endDate,
			 String dday,
			 boolean usein,
			boolean usewifi,boolean usenavi,boolean useseat) {
		String sql = "insert into carreserve"
				+ "(no,pay,id,qty,startdate,endDate,usein,usewifi,usenavi,useseat,dday) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?);";

		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			ps.setInt(2,Integer.parseInt(pay));
			ps.setString(3, id);
			ps.setString(4, qty);
			ps.setString(5, startDate);
			ps.setString(6, endDate);
			ps.setBoolean(7, usein);
			ps.setBoolean(8, usewifi);
			ps.setBoolean(9, usenavi);
			ps.setBoolean(10, useseat);
			ps.setString(11, dday);
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
	
	public boolean cancelByNo(String resv_seq) {
		String sql = "delete from carreserve where reserve_seq = ?";
		conn = MainDTO.getInstance().getConnect();
		boolean success = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, resv_seq);
			
			int r = ps.executeUpdate(); 
			success = r > 0 ? true : false ;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return success;
	}
	
	
	public ArrayList<Carreserve> getMyList(String mid) {
		String sql = "select * from carreserve c join rentcar r on c.no = r.no where c.id = ?";
		conn = MainDTO.getInstance().getConnect();
		ArrayList<Carreserve> list = new ArrayList<Carreserve>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int reserv_seq = rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				String id = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String startDate = rs.getString("startDate");
				String endDate = rs.getString("endDate");
				int pay = rs.getInt("pay");
				boolean usein = rs.getBoolean("usein");
				boolean usewifi = rs.getBoolean("usewifi");
				boolean usenavi = rs.getBoolean("usenavi");
				boolean useseat = rs.getBoolean("useseat");
				String img = rs.getString("img");
				String name = rs.getString("name");
				Carreserve res = new Carreserve(reserv_seq, no, id, qty, dday, startDate, endDate, pay, usein, usewifi, usenavi, useseat,img,name);
			    list.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public boolean deleteReserve(String id) {
		Member m = null;
		String sql = "delete from carreserve where id = ?";
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
