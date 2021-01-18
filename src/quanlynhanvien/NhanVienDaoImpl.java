package quanlynhanvien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Login.ConnectionFactory;
public class NhanVienDaoImpl implements NhanVienDao {

	@Override
	public NhanVienDto getEmployeeById(int MaNV) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM NhanVien WHERE MaNV = '" + MaNV + "'");

			if (rs.next()) {
				NhanVienDto employee = new NhanVienDto();
				employee.setMaNV(rs.getInt("MaNV"));
				employee.setMaSp(rs.getString("MaSp"));
				employee.setHoTen(rs.getString("HoTen"));
				employee.setGioiTinh(rs.getString("GioiTinh"));
				employee.setNgaySinh(rs.getDate("NgaySinh"));
				employee.setMaViTri(rs.getString("MaViTri"));
				employee.setDiaChi(rs.getString("DiaChi"));
				employee.setSoDienThoai(rs.getString("SoDienThoai"));
				return employee;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NhanVienDto> getAllEmployees() {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM NhanVien");
			List<NhanVienDto> employees = new ArrayList<>();
			while (rs.next()) {
				NhanVienDto employee = new NhanVienDto();
				employee.setMaNV(rs.getInt("MaNV"));
				employee.setMaSp(rs.getString("MaSp"));
				employee.setHoTen(rs.getString("HoTen"));
				employee.setGioiTinh(rs.getString("GioiTinh"));
				employee.setNgaySinh(rs.getDate("NgaySinh"));
				employee.setMaViTri(rs.getString("MaViTri"));
				employee.setDiaChi(rs.getString("DiaChi"));
				employee.setSoDienThoai(rs.getString("SoDienThoai"));
				
				employees.add(employee);
			}

			return employees;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertEmployee(NhanVienDto employee) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "INSERT INTO NhanVien VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, employee.getMaSp());
			ps.setString(2, employee.getHoTen());
			ps.setString(3, employee.getGioiTinh());
			ps.setDate(4, employee.getNgaySinh());
			ps.setString(5, employee.getMaViTri());
			ps.setString(6, employee.getDiaChi());
			ps.setString(7, employee.getSoDienThoai());
			

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int MaNV) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM NhanVien WHERE MaNV = '" + MaNV + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(NhanVienDto employee) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			String queryString = "UPDATE NhanVien SET MaSp = ?, HoTen = ?, GioiTinh = ?, NgaySinh = ?, MaViTri = ?, DiaChi = ?, SoDienThoai = ? WHERE MaNV = ?";
			PreparedStatement ps = connection.prepareStatement(queryString);
			ps.setString(1, employee.getMaSp());
			ps.setString(2, employee.getHoTen());
			ps.setString(3, employee.getGioiTinh());
			ps.setDate(4, employee.getNgaySinh());
			ps.setString(5, employee.getMaViTri());
			ps.setString(6, employee.getDiaChi());
			ps.setString(7, employee.getSoDienThoai());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public NhanVienDto getEmployeeByten(String HoTen) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM NhanVien WHERE HoTen = '" + HoTen + "'");

			if (rs.next()) {
				NhanVienDto employee = new NhanVienDto();
				employee.setMaNV(rs.getInt("MaNV"));
				employee.setMaSp(rs.getString("MaSp"));
				employee.setHoTen(rs.getString("HoTen"));
				employee.setGioiTinh(rs.getString("GioiTinh"));
				employee.setNgaySinh(rs.getDate("NgaySinh"));
				employee.setMaViTri(rs.getString("MaViTri"));
				employee.setDiaChi(rs.getString("DiaChi"));
				employee.setSoDienThoai(rs.getString("SoDienThoai"));

				return employee;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}


}
