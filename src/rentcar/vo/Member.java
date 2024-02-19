package rentcar.vo;

public class Member {

	private int num;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String sFileName;
	private String oFileName;

	public String getsFileName() {
		return sFileName;
	}

	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}

	public String getoFileName() {
		return oFileName;
	}

	public void setoFileName(String oFileName) {
		this.oFileName = oFileName;
	}

	public Member(int num, String id, String pass, String name, int age, String email, String phone, String sFileName,
			String oFileName) {
		this.num = num;
		this.id = id;
		this.pw = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.sFileName = sFileName;
		this.oFileName = oFileName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pass) {
		this.pw = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
