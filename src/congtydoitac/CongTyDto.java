package congtydoitac;

public class CongTyDto {
	private String MaCT;
	private String TenCT;
	private String Diachi;
	private String SDT;
	
	
	public CongTyDto() {
		super();
	}


	public CongTyDto(String maCT, String tenCT, String diachi, String sDT) {
		super();
		MaCT = maCT;
		TenCT = tenCT;
		Diachi = diachi;
		SDT = sDT;
	}


	public String getMaCT() {
		return MaCT;
	}


	public void setMaCT(String maCT) {
		MaCT = maCT;
	}


	public String getTenCT() {
		return TenCT;
	}


	public void setTenCT(String tenCT) {
		TenCT = tenCT;
	}


	public String getDiachi() {
		return Diachi;
	}


	public void setDiachi(String diachi) {
		Diachi = diachi;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}

}
