package rentcar.vo;

import java.text.DecimalFormat;

public class Carreserve {
	
	private int reserve_seq ;
	private int no;
	private String id;
    private int qty;
    private int dday;
    private String startDate;
    
	private String endDate;
    private int pay;
    private boolean usein ;
    private boolean usewifi ;
    private boolean usenavi ;
    private boolean useseat ;
    
    
    private String img;
    private String name;
    
    
    
	public Carreserve(int reserve_seq, int no, String id, int qty, int dday, String startDate, String endDate, int pay,
			boolean usein, boolean usewifi, boolean usenavi, boolean useseat,String img,String name) {
		super();
		this.reserve_seq = reserve_seq;
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pay = pay;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
		this.img = img;
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPay() {
		DecimalFormat formatter = new DecimalFormat("###,###");
		String  str = formatter.format(this.pay);
		return  str;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public boolean isUsein() {
		return usein;
	}
	public void setUsein(boolean usein) {
		this.usein = usein;
	}
	public boolean isUsewifi() {
		return usewifi;
	}
	public void setUsewifi(boolean usewifi) {
		this.usewifi = usewifi;
	}
	public boolean isUsenavi() {
		return usenavi;
	}
	public void setUsenavi(boolean usenavi) {
		this.usenavi = usenavi;
	}
	public boolean isUseseat() {
		return useseat;
	}
	public void setUseseat(boolean useseat) {
		this.useseat = useseat;
	}
    
    
    
}
