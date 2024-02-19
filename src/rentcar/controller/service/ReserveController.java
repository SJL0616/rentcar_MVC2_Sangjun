package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.ReserveDTO;

public class ReserveController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String no = req.getParameter("no"); //랜트카 고유번호
		HttpSession session = req.getSession();
		
		String id = String.valueOf(session.getAttribute("log"));
		if(id== null) return"/";
		String qty = req.getParameter("qty");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String dday = req.getParameter("dday");
		String pay = req.getParameter("pay");
		boolean usein = req.getParameterValues("usein") != null ;
		boolean usewifi = req.getParameterValues("usewifi")!= null;
		boolean usenavi = req.getParameterValues("usenavi")!= null;
		boolean useseat = req.getParameterValues("useseat")!= null;
		
		System.out.println(usein +" "+usewifi +" "+usenavi +" "+ useseat);
		
		System.out.println(no +" "+id +" "+qty +" "+ dday +" "+startDate +" "+endDate +" pay : "+pay);
		ReserveDTO reserveDTO = new ReserveDTO();
		boolean result = reserveDTO.insert(no,pay, id, qty, startDate, endDate, dday, usein, usewifi, usenavi, useseat);
		
		
		return "/";
	}

}
