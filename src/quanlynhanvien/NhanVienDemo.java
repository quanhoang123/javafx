package quanlynhanvien;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class NhanVienDemo {
	
	private SimpleIntegerProperty MaNV;
	private SimpleStringProperty MaSP;
	private SimpleStringProperty name;
	private SimpleStringProperty dateOfBirth;
	private SimpleStringProperty gender;
	private SimpleStringProperty address;
	private SimpleStringProperty phoneNumber;
	private SimpleStringProperty MaViTri;
	
	
	public NhanVienDemo() {
		
		this.MaNV= new SimpleIntegerProperty();
		this.MaSP= new SimpleStringProperty();
		this.name= new SimpleStringProperty();
		this.dateOfBirth= new SimpleStringProperty();
		this.gender= new SimpleStringProperty();
		this.address= new SimpleStringProperty();
		this.phoneNumber= new SimpleStringProperty();
		this.MaViTri =  new SimpleStringProperty();
		
	}
	
	public NhanVienDemo(Integer MaNV, String MaSP, String name, String dateOfBirth, String gender, 
			String address, String phoneNumber, String MaViTri ) {
		
		this.MaNV= new SimpleIntegerProperty(MaNV);
		this.MaSP= new SimpleStringProperty(MaSP);
		this.name= new SimpleStringProperty(name);
		this.dateOfBirth= new SimpleStringProperty(dateOfBirth);
		this.gender= new SimpleStringProperty(gender);
		this.address= new SimpleStringProperty(address);
		this.phoneNumber= new SimpleStringProperty(phoneNumber);
		this.MaViTri =  new SimpleStringProperty(MaViTri);
		
	}

	public Integer getMaNV() {
		return this.MaNV.get();
	}

	public void setMaNV(Integer MaNV) {
		this.MaNV.set(MaNV);
	}

	public String getMaSP() {
		return this.MaSP.get();
	}

	public void setMaSP(String MaSP) {
		this.MaSP.set(MaSP);
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getDateOfBirth() {
		return this.dateOfBirth.get();
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.set(dateOfBirth) ;
	}

	public String getGender() {
		return this.gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address) ;
	}

	public String getPhoneNumber() {
		return this.phoneNumber.get();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	public String getMaViTri() {
		return this.MaViTri.get();
	}

	public void setMaViTri(String MaViTri) {
		this.MaViTri.set(MaViTri);
	}
	

}
