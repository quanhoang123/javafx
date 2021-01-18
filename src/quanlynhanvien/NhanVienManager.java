package quanlynhanvien;

import java.util.List;


public interface NhanVienManager {
	
	public List<NhanVienDemo> getAllEmployees();
	public void deleteEmployee(int MaNV);
	
	public void updateEmployee(NhanVienDemo nhanvien);
	
	public void insertEmployee(NhanVienDemo nhanvien);

}
