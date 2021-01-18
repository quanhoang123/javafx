package quanlysanpham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectionFactory;

public class SanphamDaoImpl implements SanphamDao{

	@Override
	public SanphamDto getSanPhamByMasp(String MaSp) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sanpham WHERE MaSp = '" + MaSp + "'");

			if (rs.next()) {
				SanphamDto product = new SanphamDto();
				product.setMaSp(rs.getString("MaSp"));
				product.setTenSP(rs.getString("TenSP"));
				product.setMaCT(rs.getString("MaCT"));
				product.setGiaSP(rs.getString("GiaSP"));
				product.setTinhTrang(rs.getString("TinhTrang"));
				product.setNhanXet(rs.getString("NhanXet"));
				
				return product;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SanphamDto> getAllProductes() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sanpham");
			List<SanphamDto> productes = new ArrayList<>();
			while (rs.next()) {
				SanphamDto product = new SanphamDto();
				product.setMaSp(rs.getString("MaSp"));
				product.setTenSP(rs.getString("TenSP"));
				product.setMaCT(rs.getString("MaCT"));
				product.setGiaSP(rs.getString("GiaSP"));
				product.setTinhTrang(rs.getString("TinhTrang"));
				product.setNhanXet(rs.getString("NhanXet"));
				
				productes.add(product);
			}
			return productes;
		}catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertProduct(SanphamDto sanpham) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO Sanpham VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, sanpham.getMaSp());
			ps.setString(2, sanpham.getTenSP());
			ps.setString(3, sanpham.getMaCT());
			ps.setString(4, sanpham.getGiaSP());
			ps.setString(5, sanpham.getTinhTrang());
			ps.setString(6, sanpham.getNhanXet());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(String MaSp) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM Sanpham WHERE MaSp = '" + MaSp + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateProduct(SanphamDto sanpham) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE Sanpham SET TenSP = ?, MaCT = ?, GiaSP = ?, TinhTrang = ?, NhanXet = ? WHERE MaSp = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, sanpham.getMaSp());
			ps.setString(2, sanpham.getTenSP());
			ps.setString(3, sanpham.getMaCT());
			ps.setString(4, sanpham.getGiaSP());
			ps.setString(5, sanpham.getTinhTrang());
			ps.setString(6, sanpham.getNhanXet());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public SanphamDto getProductByten(String TenSP) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sanpham WHERE TenSP = '" + TenSP + "'");
			if (rs.next()) {
				SanphamDto product = new SanphamDto();
				product.setMaSp(rs.getString("MaSp"));
				product.setTenSP(rs.getString("TenSP"));
				product.setMaCT(rs.getString("MaCT"));
				product.setGiaSP(rs.getString("GiaSP"));
				product.setTinhTrang(rs.getString("TinhTrang"));
				product.setNhanXet(rs.getString("NhanXet"));
				
				return product;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
