package quanlykhachhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectionFactory;
import Login.UserDto;



public class KhachHangImpl implements KhachHangDao{

	@Override
	public KhachHangDto getKhachHangById(int maKH) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KhachHang WHERE MaKH = '" + maKH + "'");

			if (rs.next()) {
				KhachHangDto kh = new KhachHangDto();
				kh.setMaKH(rs.getInt("MaKH"));
				kh.setTen(rs.getString("TenKH"));
				kh.setTendangnhap(rs.getString("TenDangNhap"));
				kh.setPassword(rs.getString("MatKhau"));
				kh.setEmail(rs.getString("email"));
				kh.setDiaChi(rs.getString("address"));
				kh.setGioiTinh(rs.getString("gender"));	
				kh.setSdt(rs.getString("phone"));
				
				return kh;
			}
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		return null;
	}

	@Override
	public List<KhachHangDto> getAllKhachHang() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from KhachHang");
			List<KhachHangDto> khachhang = new ArrayList<>();
			while (rs.next()) {
				KhachHangDto kh = new KhachHangDto();
				kh.setMaKH(rs.getInt("MaKH"));
				kh.setTen(rs.getString("TenKH"));
				kh.setTendangnhap(rs.getString("TenDangNhap"));
				kh.setPassword(rs.getString("MatKhau"));
				kh.setEmail(rs.getString("email"));
				kh.setDiaChi(rs.getString("address"));
				kh.setGioiTinh(rs.getString("gender"));		
				kh.setSdt(rs.getString("phone"));
				
				khachhang.add(kh);
			}
			return khachhang;
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertKhachHang(KhachHangDto khachhang) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO KhachHang VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, khachhang.getTen());
			ps.setString(2, khachhang.getTendangnhap());
			ps.setString(3, khachhang.getPassword());
			ps.setString(6, khachhang.getEmail());
			ps.setString(4, khachhang.getDiaChi());
			ps.setString(5, khachhang.getGioiTinh());		
			ps.setString(7, khachhang.getSdt());
			
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteKhachHang(int maKH) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM KhachHang WHERE MaKH = '" + maKH + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(KhachHangDto khachhang) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE KhachHang SET TenKH = ?, TenDangNhap = ?, MatKhau = ?, email = ?, address = ?, gender = ?, phone = ? WHERE MaKH = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, khachhang.getTen());
			ps.setString(2, khachhang.getTendangnhap());
			ps.setString(3, khachhang.getPassword());
			ps.setString(6, khachhang.getEmail());
			ps.setString(4, khachhang.getDiaChi());
			ps.setString(5, khachhang.getGioiTinh());
			ps.setString(7, khachhang.getSdt());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public KhachHangDto getByKhachhang(String tendangnhap, String matkhau) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KhachHang WHERE TenDangNhap = '" + tendangnhap + "'" + " AND MatKhau = '" + matkhau + "'");
			if (rs.next()) {
				KhachHangDto kh = new KhachHangDto();
				kh.setMaKH(rs.getInt("MaKH"));
				kh.setTen(rs.getString("TenKH"));
				kh.setTendangnhap(rs.getString("TenDangNhap"));
				kh.setPassword(rs.getString("MatKhau"));
				kh.setEmail(rs.getString("email"));
				kh.setDiaChi(rs.getString("address"));
				kh.setGioiTinh(rs.getString("gender"));	
				kh.setSdt(rs.getString("phone"));
				
				return kh;
			}
			}catch (SQLException ex) {
				ex.printStackTrace();
			
			}
		return null;
	}

}
