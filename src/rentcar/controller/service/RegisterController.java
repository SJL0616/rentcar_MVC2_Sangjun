package rentcar.controller.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rentcar.dto.RentcarDAO;

public class RegisterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		  String isForm = req.getParameter("form");
		  System.out.println("isForm "+ isForm);
		  if(isForm != null && isForm.equals("true")) {
			  return "register";
		  }
		
		  String saveDir = req.getServletContext().getRealPath("/Uploads");
		  
		  System.out.println(saveDir.toString()); 
		  Path saveDirPath =
		  Paths.get(saveDir); 
		  if (!Files.isDirectory(saveDirPath)) {
		  Files.createDirectories(saveDirPath); 
		  } 
		  MultipartRequest multi = new MultipartRequest(req, saveDir.toString(), 5*1024*1024, "UTF-8",new
		  DefaultFileRenamePolicy());
		  
		  
		  
		  String sFileName = null; String oFileName = null;
		  if(multi.getFilesystemName("img") != null) {
	      sFileName = multi.getFilesystemName("img"); 
	      oFileName = multi.getOriginalFileName("img"); 
	      String fileType = multi.getContentType("img"); 
	      System.out.println("fileType : "+fileType +" | sFileName"+sFileName);
		  
		  }
		  String name = multi.getParameter("name");
		  int category = Integer.parseInt( multi.getParameter("category")); 
		  int price = Integer.parseInt(multi.getParameter("price")); 
		  int usePeople = Integer.parseInt(multi.getParameter("usePeople")); 
		  int total_qty = Integer.parseInt(multi.getParameter("total_qty"));
		  String company = multi.getParameter("company");
		  String info = multi.getParameter("info");
		 
		  RentcarDAO rentcarDAO = new RentcarDAO();
		  boolean success = rentcarDAO.insert(name, category, price, usePeople, total_qty, company, sFileName, info);
		  String msg = success ? "등록 성공" :"등록 실패";
		  String ctx = req.getContextPath();
		  System.out.println(msg);
		  //req.setAttribute("msg", msg); 
		  resp.setContentType("text/html; charset=UTF-8");
		
		  if(success) {
			  resp.getWriter().println("<script>alert('등록 성공');location.href='"+ctx+"'; </script> ");
		  }else {
			    resp.getWriter().println("<script>alert('등록 실패');location.href='"+ctx+"';</script> ");
		  }
		  

	return null;
}

}
