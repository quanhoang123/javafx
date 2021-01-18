package quanlynhanvien;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NhanVienManagerImpl implements NhanVienManager {
	
	private NhanVienDao employeeDao = new NhanVienDaoImpl();

	@Override
	public List<NhanVienDemo> getAllEmployees() {
		List<NhanVienDto> employees = employeeDao.getAllEmployees();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		List<NhanVienDemo> list = new ArrayList<>();
		
		if(employees!= null) {
		for (NhanVienDto emp : employees) {
			NhanVienDemo employee = new NhanVienDemo();
			employee.setMaNV(emp.getMaNV());
			employee.setMaSP(emp.getMaSp());
			employee.setName(emp.getHoTen());
			employee.setAddress(emp.getDiaChi());
			employee.setDateOfBirth(dateFormat.format(emp.getNgaySinh()));
			employee.setPhoneNumber(emp.getSoDienThoai());
			employee.setGender(emp.getGioiTinh().equals("Nam") ? "Male" : "Female");
			employee.setMaViTri(emp.getMaViTri());
			
			list.add(employee);
		}
		}
		return list;
	}

	@Override
	public void deleteEmployee(int MaNV) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateEmployee(NhanVienDemo nhanvien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEmployee(NhanVienDemo nhanvien) {
		// TODO Auto-generated method stub
		
	}
	

}
