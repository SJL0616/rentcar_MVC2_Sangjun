package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dto.MemberDAO;

public class JoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id == null) {
			return "joinForm";
		}
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String job = req.getParameter("job");
		String hobby = req.getParameter("hobby");
		String age = req.getParameter("age");
		String info = req.getParameter("info");

		MemberDAO memberDAO = new MemberDAO();
		boolean success = memberDAO.insert(id, pw, email, tel, hobby, job, age, info);
		String msg = success ? "등록 성공" :"등록 실패";
		String ctx = req.getContextPath();
		System.out.println(msg);
		
		resp.setContentType("text/html; charset=UTF-8");
		if(success) {
			HttpSession session = req.getSession();
			session.setAttribute("log", id);
			resp.getWriter().println("<script>alert('회원가입 성공');location.href='"+ctx+"'; </script> ");
		}else {
			  resp.getWriter().println("<script>alert('회원가입 실패');location.href='"+ctx+"';</script> ");
		}
		return null;
	}

}
