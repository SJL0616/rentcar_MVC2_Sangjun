package rentcar.controller.front;

public class ViewResolver {

	public static String makeView(String url){
		if(url.equals("/")) {
			return "/index.jsp";
		}
		if(url.contains(".do")) {
			return "/"+url;
		}
		return "/WEB-INF/rentcar/"+url+".jsp";
	}
}
