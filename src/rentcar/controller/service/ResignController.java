package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.MemberDAO;
import rentcar.dto.ReserveDTO;

public class ResignController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();

		String id = (String) session.getAttribute("log");
		ReserveDTO reserveDTO = new ReserveDTO();
		MemberDAO memDao = new MemberDAO();
		
		boolean success1 = reserveDTO.deleteReserve(id);
		boolean success2 = memDao.deleteMember(id);
		String ctx = req.getContextPath();
		resp.setContentType("text/html; charset=UTF-8");

		if (success1 && success2) {
			session.removeAttribute("log");
			resp.getWriter().println("<script>alert('회원 탈퇴 성공');location.href='" + ctx + "'; </script> ");
		} else {
			resp.getWriter().println("<script>alert('회원 탈퇴 실패');location.href='" + ctx + "';</script> ");
		}

		return null;
	}

}
