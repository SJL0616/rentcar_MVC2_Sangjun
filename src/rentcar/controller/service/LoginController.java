package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.MemberDAO;


public class LoginController implements Controller{

	MemberDAO memberDAO = null;
	
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if(id == null) {
			return "login";
		}
		String pw = req.getParameter("pw");
		
		if(id == null || pw == null) {
			return "02_memberLogin";
		}
		memberDAO = new MemberDAO();
		
		boolean success = memberDAO.checkLogin(id, pw);
		if(success) {
			HttpSession session = req.getSession();
			session.setAttribute("log", id);
		}
		resp.getWriter().print(success ? 1 : 0); 
		return null;
	}

}
