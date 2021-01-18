package congtydoitac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectionFactory;

public class CongTyDaoImpl implements CongTyDao{

	@Override
	public CongTyDto getCongTyByMaCT(String MaCT) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CongTy WHERE MaCT = '" + MaCT + "'");

			if (rs.next()) {
				CongTyDto congty = new CongTyDto();
				congty.setMaCT(rs.getString("MaCT"));
				congty.setTenCT(rs.getString("TenCT"));
				congty.setDiachi(rs.getString("DiaChi"));
				congty.setSDT(rs.getString("SDT"));
				
				return congty;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CongTyDto> getAllCongTy() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CongTy");
			List<CongTyDto> doitac = new ArrayList<>();
			while (rs.next()) {
				CongTyDto congty = new CongTyDto();
				congty.setMaCT(rs.getString("MaCT"));
				congty.setTenCT(rs.getString("TenCT"));
				congty.setDiachi(rs.getString("DiaChi"));
				congty.setSDT(rs.getString("SDT"));
				
				doitac.add(congty);
			}
				return doitac;
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
		return null;
	}

	@Override
	public void insertCongTy(CongTyDto congty) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO ViTriLamViec VALUES(?, ?, ?,?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, congty.getMaCT());
			ps.setString(2, congty.getTenCT());
			ps.setString(3, congty.getDiachi());
			ps.setString(4, congty.getSDT());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteCongTy(String MaCT) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM CongTy WHERE MaCT = '" + MaCT + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateCongTy(CongTyDto congty) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE CongTy SET TenCT = ?,DiaChi  = ?,SDT = ? WHERE MaCT = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, congty.getMaCT());
			ps.setString(2, congty.getTenCT());
			ps.setString(3, congty.getDiachi());
			ps.setString(4, congty.getSDT());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public CongTyDto getCongTyByten(String TenCT) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CongTy WHERE TenCT = '" + TenCT + "'");
			if (rs.next()) {	
				CongTyDto congty = new CongTyDto();
				congty.setMaCT(rs.getString("MaCT"));
				congty.setTenCT(rs.getString("TenCT"));
				congty.setDiachi(rs.getString("DiaChi"));
				congty.setSDT(rs.getString("SDT"));
				
				return congty;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
