package rentcar.controller.front;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.controller.service.Controller;

/**
 * Servlet implementation class MemberfrontController
 */
@WebServlet("*.do")
public class MemberfrontController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");
		String url = req.getRequestURI();
		String ctx = req.getContextPath();

		String command = url.substring(ctx.length());
		System.out.println("command : " + command);
		Controller controller = null;
		String nextUrl = null;

		controller = HandlerMapping.getInstance().getController(command);
		nextUrl = controller.requestHandler(req, resp);

		if (nextUrl != null) {
			if (nextUrl.indexOf("redirect:") != -1) {
				resp.sendRedirect(nextUrl.split(":")[1]);
			} else {
				System.out.println("to page");
				RequestDispatcher dis = req.getRequestDispatcher(ViewResolver.makeView(nextUrl));
				System.out.println(ViewResolver.makeView(nextUrl));
				dis.forward(req, resp);
			}
		}
	}
}
