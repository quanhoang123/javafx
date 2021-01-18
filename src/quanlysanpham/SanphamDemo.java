package quanlysanpham;

import javafx.beans.property.SimpleStringProperty;

public class SanphamDemo {
	
	private SimpleStringProperty MaSP;
	private SimpleStringProperty tenSP;
	private SimpleStringProperty MaCT;
	private SimpleStringProperty GiaSP;
	private SimpleStringProperty TinhTrang;
	private SimpleStringProperty NhanXet;
	
	
	public SanphamDemo() {
		this.MaSP= new SimpleStringProperty();
		this.tenSP= new SimpleStringProperty();
		this.MaCT= new SimpleStringProperty();
		this.GiaSP= new SimpleStringProperty();
		this.TinhTrang= new SimpleStringProperty();
		this.NhanXet= new SimpleStringProperty();
	}


	public SanphamDemo(String maSP, String tenSP, String maCT,
			String giaSP, String tinhTrang, String nhanXet) {
		MaSP = new SimpleStringProperty(maSP);
		this.tenSP = new SimpleStringProperty(tenSP);
		MaCT = new SimpleStringProperty(maCT);
		GiaSP = new SimpleStringProperty(giaSP);
		TinhTrang = new SimpleStringProperty(tinhTrang);
		NhanXet = new SimpleStringProperty(nhanXet);
	}


	public String getMaSP() {
		return this.MaSP.get();
	}


	public void setMaSP(String maSP) {
		this.MaSP.set(maSP);
	}


	public String getTenSP() {
		return this.tenSP.get();
	}


	public void setTenSP(String tenSP) {
		this.tenSP.set(tenSP);
	}


	public String getMaCT() {
		return MaCT.get();
	}


	public void setMaCT(String maCT) {
		MaCT.set(maCT);;
	}


	public String getGiaSP() {
		return GiaSP.get();
	}


	public void setGiaSP(String giaSP) {
		GiaSP.set(giaSP);
	}


	public String getTinhTrang() {
		return TinhTrang.get();
	}


	public void setTinhTrang(String tinhTrang) {
		TinhTrang.set(tinhTrang);;
	}


	public String getNhanXet() {
		return NhanXet.get();
	}


	public void setNhanXet(String nhanXet) {
		NhanXet.set(nhanXet);
	}
	
	
	
	

}
