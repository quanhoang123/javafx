package quanlysanpham;

public class SanphamDto {
	private String MaSp;
	private String TenSP;
	private String MaCT;
	private String GiaSP;
	private String TinhTrang;
	private String NhanXet;
	
	
	public SanphamDto(String maSp, String tenSP, String maCT, String giaSP, String tinhTrang, String nhanXet) {
		super();
		MaSp = maSp;
		TenSP = tenSP;
		MaCT = maCT;
		GiaSP = giaSP;
		TinhTrang = tinhTrang;
		NhanXet = nhanXet;
	}
	public SanphamDto() {
		super();
	}
	public String getMaSp() {
		return MaSp;
	}
	public void setMaSp(String maSp) {
		MaSp = maSp;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMaCT() {
		return MaCT;
	}
	public void setMaCT(String maCT) {
		MaCT = maCT;
	}
	public String getGiaSP() {
		return GiaSP;
	}
	public void setGiaSP(String giaSP) {
		GiaSP = giaSP;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public String getNhanXet() {
		return NhanXet;
	}
	public void setNhanXet(String nhanXet) {
		NhanXet = nhanXet;
	}

}
