package quanlynhanvien;

import java.util.List;

public interface NhanVienDao {
	
	public NhanVienDto getEmployeeById(int MaNV);
	
	public List<NhanVienDto> getAllEmployees();
	
	public void insertEmployee(NhanVienDto nhanvien);
	
	public void deleteEmployee(int MaNV);
	
	public void updateEmployee(NhanVienDto nhanvien);
	
	public NhanVienDto getEmployeeByten(String HoTen);

}
