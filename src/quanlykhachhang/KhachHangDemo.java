package quanlykhachhang;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class KhachHangDemo {
	private SimpleIntegerProperty maKH;
	private SimpleStringProperty ten;
	private SimpleStringProperty tendangnhap;
	private SimpleStringProperty matkhau;
	private SimpleStringProperty diachi;
	private SimpleStringProperty sdt;
	private SimpleStringProperty gender;
	private SimpleStringProperty email;
	
	
	public KhachHangDemo() {
		this.maKH = new SimpleIntegerProperty();
		this.ten = new SimpleStringProperty( );
		this.tendangnhap = new SimpleStringProperty();
		this.matkhau = new SimpleStringProperty();
		this.diachi = new SimpleStringProperty();
		this.sdt = new SimpleStringProperty();
		this.gender = new SimpleStringProperty();
		this.email = new SimpleStringProperty();
		
	}

	public KhachHangDemo(int maKH, String ten, String tendangnhap,
			String matkhau, String diachi, String sdt,
			String gender, String email) {
		this.maKH = new SimpleIntegerProperty(maKH);
		this.ten = new SimpleStringProperty( ten);
		this.tendangnhap = new SimpleStringProperty(tendangnhap);
		this.matkhau = new SimpleStringProperty(matkhau);
		this.diachi = new SimpleStringProperty(diachi);
		this.sdt = new SimpleStringProperty(sdt);
		this.gender = new SimpleStringProperty(gender);
		this.email = new SimpleStringProperty(email);
	}

	public Integer getMaKH() {
		return this.maKH.get();
	}

	public void setMaKH(int maKH) {
		this.maKH.set(maKH);
	}

	public String getTen() {
		return this.ten.get();
	}

	public void setTen(String ten) {
		this.ten.set(ten);
	}

	public String getTendangnhap() {
		return this.tendangnhap.get();
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap.set(tendangnhap);
	}

	public String getMatkhau() {
		return this.matkhau.get();
	}

	public void setMatkhau(String matkhau) {
		this.matkhau.set(matkhau);
	}

	public String getDiachi() {
		return this.diachi.get();
	}

	public void setDiachi(String diachi) {
		this.diachi.set(diachi);
	}

	public String getSdt() {
		return this.sdt.get();
	}

	public void setSdt(String sdt) {
		this.sdt .set(sdt);;
	}

	public String getGender() {
		return this.gender.get();
	}

	public void setGender(String gender) {
		this.gender .set(gender);
	}

	public String getEmail() {
		return this.email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}
	
	

}
