package rentcar.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dto.ReserveDTO;

public class CancelController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String resv_seq = req.getParameter("resv_seq");
		
		ReserveDTO reserveDTO = new ReserveDTO();
		boolean success = reserveDTO.cancelByNo(resv_seq);
		resp.getWriter().print(success);
		return null;
	}

}
