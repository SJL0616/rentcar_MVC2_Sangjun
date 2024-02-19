package rentcar.vo;

import java.text.DecimalFormat;
import java.util.Objects;

public class Rentcar {
	private int no;
	private String name;
	private int category;
	private int price;
	private int usepeople;
	private int total_qty;
	private String company;
	private String img;
	private String info;
	
	public Rentcar(int no, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		String str= "소형차";
		if(this.category != 1) {
			str = this.category == 2 ? "중형차" : "대형차";
		}
		return str;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPriceNum() {
		return this.price;
	}
	public String getPrice() {
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		String str = formatter.format(this.price);
		return str;
	}
	public String getTotalPrice(long day) {
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		String str = formatter.format(this.price*day);
		return str;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUsepeople() {
		return usepeople;
	}
	public void setUsepeople(int usepeople) {
		this.usepeople = usepeople;
	}
	public int getTotal_qty() {
		return total_qty;
	}
	public void setTotal_qty(int total_qty) {
		this.total_qty = total_qty;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public boolean equals(Object obj) {
		Rentcar compareCar = (Rentcar)obj;
		if(this.no == compareCar.getNo()){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getNo();
	}
}
