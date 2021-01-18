package quanlykhachhang;

import java.util.ArrayList;
import java.util.List;

import Login.UserDto;

public class IKhachHangManagerImpl implements IKhachHangManager {
	private KhachHangDao kh = new KhachHangImpl();

	@Override
	public List<KhachHangDemo> getAllKhachHang() {
		// TODO Auto-generated method stub
		List<KhachHangDto> khachhang = kh.getAllKhachHang();

		List<KhachHangDemo> list = new ArrayList<>();

		if (khachhang != null) {
			for (KhachHangDto khang : khachhang) {
				KhachHangDemo khachhangdemo = new KhachHangDemo();
				khachhangdemo.setMaKH(khang.getMaKH());
				khachhangdemo.setTen(khang.getTen());
				khachhangdemo.setTendangnhap(khang.getTendangnhap());
				khachhangdemo.setMatkhau(khang.getPassword());
				khachhangdemo.setEmail(khang.getEmail());
				khachhangdemo.setDiachi(khang.getDiaChi());
				khachhangdemo.setGender(khang.getGioiTinh().equals("nam") ? "Male" : "Female");
				khachhangdemo.setSdt(khang.getSdt());
				

				list.add(khachhangdemo);
			}
		}
		return list;
	}

	@Override
	public boolean checkLogin(String TenDangNhap, String MatKhau) {
		// TODO Auto-generated method stub
		KhachHangDto khachhang = kh.getByKhachhang(TenDangNhap, MatKhau);
		if (khachhang != null) {
			return true;
		} else {
			return false;
		}
	}

}
