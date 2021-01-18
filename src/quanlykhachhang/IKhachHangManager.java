package quanlykhachhang;

import java.util.List;

public interface IKhachHangManager {
	public List<KhachHangDemo> getAllKhachHang();
	
	public boolean checkLogin(String TenDangNhap, String MatKhau);

}
