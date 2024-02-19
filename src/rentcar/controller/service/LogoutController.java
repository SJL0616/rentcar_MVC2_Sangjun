package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.MemberDAO;


public class LogoutController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("log");
		String msg = "로그아웃되었습니다.";
		req.setAttribute("msg", msg);
		String ctx = req.getContextPath();
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println("<script>alert('로그아웃되었습니다.');location.href='" + ctx + "'; </script> ");
		
		return null;
	}

}
