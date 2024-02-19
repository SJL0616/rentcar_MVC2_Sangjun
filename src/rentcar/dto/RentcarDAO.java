package rentcar.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rentcar.vo.Member;
import rentcar.vo.Rentcar;

public class RentcarDAO {
	public RentcarDAO() {

	}

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;

	public ArrayList<Rentcar> getRentcarList(String startDate, String endDate) {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();

		String sql = 
				"select * from rentcar  join carreserve on rentcar.no = carreserve.no "
				+ " group by rentcar.no "
				+ " having rentcar.total_qty - sum( case when startDate <= ? and endDate >= ? then qty else 0 end)  > 0 "
				+ " union " 
				+ " select * from rentcar "
				+ " left join carreserve " + "on rentcar.no = carreserve.no " + " group by rentcar.no having carreserve.no is null";
		conn = MainDTO.getInstance().getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, endDate);
			ps.setString(2, startDate);
			rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar c = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);

				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}

	public ArrayList<Rentcar> getRentcarListInCate(String startDate, String endDate, String str) {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		int cate = Integer.parseInt(str);
		String sql = "";
		if (cate != 0) {
			sql = "select * from rentcar  join carreserve on rentcar.no = carreserve.no "
					+ " group by rentcar.no "
					+ " having rentcar.total_qty - sum( case when startDate <= ? and endDate >= ? then qty else 0 end)  > 0 and rentcar.category =? "
					+ " union " 
					+ " select * from rentcar "
					+ " left join carreserve " + "on rentcar.no = carreserve.no " + " group by rentcar.no having carreserve.no is null and rentcar.category = ?";
			
			/*
					"select * from rentcar " + " join carreserve " + "on rentcar.no = carreserve.no " + "where "
					+ " ((carreserve.endDate >? and   carreserve.endDate <?)"
					+ " or (carreserve.startDate > ? and   carreserve.startDate <?))"
					+ " group by rentcar.no "
					+ " having sum(carreserve.qty) < rentcar.total_qty and rentcar.category = ?" 
					+ " union "
					
					+" select * from rentcar " + " join carreserve " + "on rentcar.no = carreserve.no " + "where "
					+ " ((carreserve.endDate <? and   carreserve.startDate <?)"
					+ " or (carreserve.endDate > ? and   carreserve.startDate >?))"
					+ " group by rentcar.no having rentcar.category = ?"
					
					+ " union " 
					+ " select * from rentcar "
					+ " left join carreserve " + "on rentcar.no = carreserve.no " + " group by rentcar.no having carreserve.no is null and rentcar.category = ?";
			
			
			 * "select * from rentcar " + " join carreserve " +
			 * "on rentcar.no = carreserve.no " + "where " + "(carreserve.endDate > ? " +
			 * "and carreserve.startDate < ?) " + "group by rentcar.no " +
			 * "having sum(carreserve.qty) < rentcar.total_qty " +
			 * "and rentcar.category =? " + "union " + "select * from rentcar " +
			 * "left join carreserve " + "on rentcar.no = carreserve.no " +
			 * "group by rentcar.no " +
			 * "having carreserve.no is null and rentcar.category =?";
			 */
		} else {
			sql = 
					 "select * from rentcar  join carreserve on rentcar.no = carreserve.no "
					+ " group by rentcar.no "
					+ " having rentcar.total_qty - sum( case when startDate <= ? and endDate >= ? then qty else 0 end)  > 0 and rentcar.category >? "
					+ " union " 
					+ " select * from rentcar "
					+ " left join carreserve " + "on rentcar.no = carreserve.no " + " group by rentcar.no having carreserve.no is null and rentcar.category > ?";
						
					
					
			/*	
					"select * from rentcar " + " join carreserve " + "on rentcar.no = carreserve.no " + "where "
					+ " ((carreserve.endDate >? and   carreserve.endDate <?)"
					+ " or (carreserve.startDate > ? and   carreserve.startDate <?))"
					+ " group by rentcar.no "
					+ " having sum(carreserve.qty) < rentcar.total_qty and rentcar.category > ?" 
					+ " union "
					
					+" select * from rentcar " + " join carreserve " + "on rentcar.no = carreserve.no " + "where "
					+ " ((carreserve.endDate <? and   carreserve.startDate <?)"
					+ " or (carreserve.endDate > ? and   carreserve.startDate >?))"
					+ " group by rentcar.no "
					+ " having rentcar.category > ?"
					
					+ " union " 
					+ " select * from rentcar "
					+ " left join carreserve " + "on rentcar.no = carreserve.no " + " group by rentcar.no having carreserve.no is null and rentcar.category > ?";
					
			
			 * "select * from rentcar " + " join carreserve " +
			 * "on rentcar.no = carreserve.no " + "where " + "(carreserve.endDate > ? " +
			 * "and carreserve.startDate < ?) " + "group by rentcar.no " +
			 * "having sum(carreserve.qty) < rentcar.total_qty " +
			 * "and rentcar.category >? " + "union " + "select * from rentcar " +
			 * "left join carreserve " + "on rentcar.no = carreserve.no " +
			 * "group by rentcar.no " +
			 * "having carreserve.no is null and rentcar.category >?";
			 */
		}

		//System.out.println(sql);
		conn = MainDTO.getInstance().getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, endDate);
			ps.setString(2, startDate);
			ps.setInt(3, cate);
			ps.setInt(4, cate);

			rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar c = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);

				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}

	public Rentcar getRentcar(String num) {
		String sql = "select * from rentcar where no =?";
		Rentcar c = null;
		conn = MainDTO.getInstance().getConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);

			rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				c = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return c;
	}
	
	//상세 정보 페이지에서 렌트 가능 차량 표시
	public int getAbleCntByNum(String startDate, String endDate, String num) {
		String sql = "select "
				+ " rentcar.total_qty - sum(carreserve.qty)"
				+ " as ableCnt from rentcar "
				+ " join carreserve "
				+ " on rentcar.no = carreserve.no "
				+ " where "
				+ " (carreserve.endDate > ? "
				+ " and carreserve.startDate < ?) "
				+ " and rentcar.no =?";
		conn = MainDTO.getInstance().getConnect();
		int ableCnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ps.setString(3, num);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				ableCnt = rs.getInt("ableCnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return ableCnt;
	}
	
	
	
	public boolean insert(String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		String sql = "insert into rentcar (name,category,price,usepeople,total_qty,company,img,info) values(?,?,?,?,?,?,?,?);";
	
		try {
			conn = MainDTO.getInstance().getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, category);
			ps.setInt(3, price);
			ps.setInt(4, usepeople);
			ps.setInt(5, total_qty);
			ps.setString(6, company);
			ps.setString(7, img);
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
