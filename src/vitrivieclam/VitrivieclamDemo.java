package vitrivieclam;

import javafx.beans.property.SimpleStringProperty;

public class VitrivieclamDemo {
	private SimpleStringProperty maViTri;
	private SimpleStringProperty viTriLV;
	private SimpleStringProperty luong;
	
	public VitrivieclamDemo() {
		this.maViTri= new SimpleStringProperty();
		this.viTriLV= new SimpleStringProperty();
		this.luong= new SimpleStringProperty();
	}

	public VitrivieclamDemo(String maViTri, String viTriLV, String luong) {
		this.maViTri= new SimpleStringProperty(maViTri);
		this.viTriLV= new SimpleStringProperty(viTriLV);
		this.luong= new SimpleStringProperty(luong);
	}

	public String getMaViTri() {
		return this.maViTri.get();
	}

	public void setMaViTri(String maViTri) {
		this.maViTri.set(maViTri);
	}

	public String getViTriLV() {
		return this.viTriLV.get();
	}

	public void setViTriLV(String viTriLV) {
		this.viTriLV.set(viTriLV);
	}

	public String getLuong() {
		return this.luong.get();
	}

	public void setLuong(String luong) {
		this.luong.set(luong);
	}
	
	

}
