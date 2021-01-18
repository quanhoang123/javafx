package vitrivieclam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectionFactory;


public class VitrivieclamDaoImpl implements VitrivieclamDao{

	@Override
	public VitrivieclamDto getBanByMasp(String MaViTri) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ViTriLamViec WHERE MaViTri = '" + MaViTri + "'");

			if (rs.next()) {
				VitrivieclamDto vitri = new VitrivieclamDto();
				vitri.setMaViTri(rs.getString("MaViTri"));
				vitri.setViTriLV(rs.getString("ViTriLV"));
				vitri.setLuong(rs.getString("Luong"));
				
				return vitri;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<VitrivieclamDto> getAllBan() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ViTriLamViec");
			List<VitrivieclamDto> vitrilamviec = new ArrayList<>();
			while (rs.next()) {
				VitrivieclamDto vitri = new VitrivieclamDto();
				vitri.setMaViTri(rs.getString("MaViTri"));
				vitri.setViTriLV(rs.getString("ViTriLV"));
				vitri.setLuong(rs.getString("Luong"));
				
				vitrilamviec.add(vitri);
			}
			return vitrilamviec;
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertBan(VitrivieclamDto ban) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO ViTriLamViec VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, ban.getMaViTri());
			ps.setString(2, ban.getViTriLV());
			ps.setString(3, ban.getLuong());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteBan(String MaViTri) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM ViTriLamViec WHERE MaViTri = '" + MaViTri + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateBan(VitrivieclamDto ban) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE ViTriLamViec SET ViTriLV = ?,Luong  = ? WHERE MaViTri = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, ban.getMaViTri());
			ps.setString(2, ban.getViTriLV());
			ps.setString(3, ban.getLuong());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public VitrivieclamDto getBanByten(String ViTriLV) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ViTriLamViec WHERE ViTriLV = '" + ViTriLV + "'");
			if (rs.next()) {
				VitrivieclamDto vitri = new VitrivieclamDto();
				vitri.setMaViTri(rs.getString("MaViTri"));
				vitri.setViTriLV(rs.getString("ViTriLV"));
				vitri.setLuong(rs.getString("Luong"));
				
				return vitri;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
