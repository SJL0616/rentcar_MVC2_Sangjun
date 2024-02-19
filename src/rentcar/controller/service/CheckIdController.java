package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dto.MemberDAO;
import rentcar.vo.Member;

public class CheckIdController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = req.getParameter("id");
		MemberDAO memberDAO = new MemberDAO();
		boolean isExist =  memberDAO.checkId(id);
		if(isExist) {
			resp.getWriter().print(true);
		}else {
			resp.getWriter().print(false);
		}
		return null;
	}

}
