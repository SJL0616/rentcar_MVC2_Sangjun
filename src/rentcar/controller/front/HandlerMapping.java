package rentcar.controller.front;

import java.util.HashMap;

import rentcar.controller.service.CancelController;
import rentcar.controller.service.CheckIdController;
import rentcar.controller.service.Controller;
import rentcar.controller.service.JoinController;
import rentcar.controller.service.LoginController;
import rentcar.controller.service.LogoutController;
import rentcar.controller.service.MyReserveController;
import rentcar.controller.service.RegisterController;
import rentcar.controller.service.ReserveController;
import rentcar.controller.service.ResignController;
import rentcar.controller.service.SearchController;
import rentcar.controller.service.ShowInfoController;

public class HandlerMapping {
	
	private HashMap<String, Controller> mappings;
	
	static HandlerMapping instance;
	
	private HandlerMapping() {
		if(mappings == null) {
			init();
		}
	};
	
	public static HandlerMapping getInstance() {
		if(instance == null) {
			instance = new HandlerMapping();
		
		}
		return instance;
	}
	
	private void init(){
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/search.do", new SearchController());
		mappings.put("/showInfo.do", new ShowInfoController());
		mappings.put("/reserve.do", new ReserveController());
		mappings.put("/myReserve.do", new MyReserveController());
		mappings.put("/cancel.do", new CancelController());
		mappings.put("/register.do", new RegisterController());
		mappings.put("/join.do", new JoinController());
		mappings.put("/resign.do", new ResignController());
		mappings.put("/checkId.do", new CheckIdController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
	
}
