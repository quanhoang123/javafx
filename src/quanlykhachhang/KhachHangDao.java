package quanlykhachhang;

import java.util.List;

import Login.UserDto;



public interface KhachHangDao {
public KhachHangDto getKhachHangById(int maKH);
	
	public List<KhachHangDto> getAllKhachHang();
	
	public void insertKhachHang(KhachHangDto khachhang);
	
	public void deleteKhachHang(int maKH);
	
	public void updateEmployee(KhachHangDto khachhang);
	
	public KhachHangDto getByKhachhang(String tendangnhap, String matkhau);

}
