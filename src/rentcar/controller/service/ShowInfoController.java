package rentcar.controller.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dto.RentcarDAO;
import rentcar.vo.Rentcar;

public class ShowInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = req.getParameter("num");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String useDay = req.getParameter("useDay");
		
		String start = startDate.trim().split(" ")[0];
		String end = endDate.trim().split(" ")[0];
		System.out.println(start +" "+end) ;
		
		/*
		 * Date dates = null; Date datee = null; long useDay = 0; try { dates = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(start); datee = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(end); Calendar cmpDates =
		 * Calendar.getInstance(); Calendar cmpDatee = Calendar.getInstance();
		 * cmpDates.setTime(dates); //특정 일자 cmpDatee.setTime(datee); //특정 일자
		 * 
		 * long diffSec = (cmpDatee.getTimeInMillis() - cmpDates.getTimeInMillis()) /
		 * 1000; useDay = diffSec / (24*60*60)+1; //일자수 차이 } catch (ParseException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		RentcarDAO rentcarDAO = new RentcarDAO();
		Rentcar vo = rentcarDAO.getRentcar(num);
		System.out.println(startDate +" "+endDate + " "+ num);
		int ableCnt = rentcarDAO.getAbleCntByNum(startDate, endDate, num);
		if(ableCnt == 0) {
			ableCnt = vo.getTotal_qty();
		}else if (ableCnt < 0) {
			ableCnt = 0;
		}
		req.setAttribute("vo", vo);
		req.setAttribute("ableCnt", ableCnt);
		req.setAttribute("useDay", useDay);
		req.setAttribute("startDate", startDate );
		req.setAttribute("endDate", endDate );
		System.out.println(vo+" "+ ableCnt);
		
		return "showInfo";
	}

}
