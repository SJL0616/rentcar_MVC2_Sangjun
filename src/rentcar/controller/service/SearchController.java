package rentcar.controller.service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonArray;

import rentcar.dto.MainDTO;
import rentcar.dto.RentcarDAO;
import rentcar.vo.Rentcar;

public class SearchController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String useDay = req.getParameter("useDay");
		String startDate = req.getParameter("startDate");
		String startHour = req.getParameter("startHour");
		
		String endDate = req.getParameter("endDate");
		String endHour = req.getParameter("endHour");
		
		String location = req.getParameter("location");
		//System.out.println(startDate +" "+ startHour);
		//System.out.println(endDate +" "+ endHour);
		//System.out.println(location);
		RentcarDAO rentcarDAO = new RentcarDAO();
		
		String category = req.getParameter("category");
		System.out.println(category);
		ArrayList<Rentcar> list = null;
		if(startHour != null) {
			list = rentcarDAO.getRentcarList(startDate+" "+startHour, endDate+" "+endHour);
		}else {
			list = rentcarDAO.getRentcarListInCate(startDate, endDate, category);
		}
		List<Rentcar> newList = list.stream().distinct().collect(Collectors.toList());
		
		req.setAttribute("startDate", (startDate +" "+ startHour));
		req.setAttribute("endDate", (endDate +" "+ endHour));
		req.setAttribute("list", newList);
		req.setAttribute("useDay", useDay);
		
		/*
		 * for(Rentcar car : list) { System.out.println(car.getName()+" "+ car.getNo());
		 * };
		 */
		
		if(category == null) {
			
			return "carList";
		}else {
			JSONArray ja = new JSONArray();
			for(Rentcar car : list) {
				 System.out.println(car.getName()+" "+ car.getNo());
				 JSONObject jobj = new JSONObject();
				 jobj.put("no", car.getNo());
				 jobj.put("name", car.getName());
				 jobj.put("img", car.getImg());
				 jobj.put("category", car.getCategory());
				 jobj.put("usepeople", car.getUsepeople());
				 jobj.put("price", car.getTotalPrice(Long.valueOf(useDay)));
				 ja.add(jobj);
			};
			resp.setContentType("text/html; charset=utf-8");
			resp.getWriter().print(ja.toString());
			resp.getWriter().close();
			return null;
		}
	}

}
