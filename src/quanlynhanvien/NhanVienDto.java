package quanlynhanvien;

import java.sql.Date;

public class NhanVienDto {	
	private int  MaNV;
	private String  MaSp;
	private String  HoTen;
	private Date  NgaySinh;
	private String  GioiTinh;
	private String  DiaChi;
	private String  SoDienThoai;
	private String  MaViTri;
	
	
	public int getMaNV() {
		return MaNV;
	}


	public void setMaNV(int maNV) {
		MaNV = maNV;
	}


	public String getMaSp() {
		return MaSp;
	}


	public void setMaSp(String maSp) {
		MaSp = maSp;
	}


	public String getHoTen() {
		return HoTen;
	}


	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public Date getNgaySinh() {
		return NgaySinh;
	}


	public void setNgaySinh(Date string) {
		NgaySinh = string;
	}


	public String getGioiTinh() {
		return GioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}


	public String getDiaChi() {
		return DiaChi;
	}


	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}


	public String getSoDienThoai() {
		return SoDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}


	public String getMaViTri() {
		return MaViTri;
	}


	public void setMaViTri(String maViTri) {
		MaViTri = maViTri;
	}


	public NhanVienDto() {
		super();
	}


	public NhanVienDto(int maNV, String maSp, String hoTen, Date ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, String maViTri) {
		super();
		MaNV = maNV;
		MaSp = maSp;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		MaViTri = maViTri;
	}

}
