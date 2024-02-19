package rentcar.controller.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.ReserveDTO;
import rentcar.vo.Carreserve;

public class MyReserveController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ReserveDTO res = new ReserveDTO();
		HttpSession session = req.getSession();
		String id = String.valueOf(session.getAttribute("log"));
		ArrayList<Carreserve> list = res.getMyList( id);
		if(list.size() > 0) {
			req.setAttribute("list", list);
		}else {
			req.setAttribute("list", null);
		}
		
		
		return "myReserv";
	}

}
