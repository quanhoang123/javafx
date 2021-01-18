package quanlykhachhang;

public class KhachHangDto {
	private int maKH;
	private String tendangnhap;
	private String password;
	private String ten;
	private String sdt;
	private String gioiTinh;
	private  String diaChi;
	private String email;
	
	public KhachHangDto() {
	}

	public KhachHangDto(int maKH, String tendangnhap, String password, String ten,  String gioiTinh,
			String diaChi, String email) {
		this.maKH = maKH;
		this.tendangnhap = tendangnhap;
		this.password = password;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.email = email;
	}
	

	public KhachHangDto(int maKH, String tendangnhap, String password, String ten, String sdt, String gioiTinh,
			String diaChi, String email) {
		this.maKH = maKH;
		this.tendangnhap = tendangnhap;
		this.password = password;
		this.ten = ten;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.email = email;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
