package vitrivieclam;

public class VitrivieclamDto {
	private String maViTri;
	private String viTriLV;
	private String luong;
	
	public VitrivieclamDto(String maViTri, String viTriLV, String luong) {
		
		this.maViTri = maViTri;
		this.viTriLV = viTriLV;
		this.luong = luong;
	}

	public VitrivieclamDto() {
		super();
	}

	public String getMaViTri() {
		return maViTri;
	}

	public void setMaViTri(String maViTri) {
		this.maViTri = maViTri;
	}

	public String getViTriLV() {
		return viTriLV;
	}

	public void setViTriLV(String viTriLV) {
		this.viTriLV = viTriLV;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

}
