package quanlysanpham;

import java.util.List;


public interface SanphamDao {
	
   public SanphamDto getSanPhamByMasp(String MaSp);
	
	public List<SanphamDto> getAllProductes();
	
	public void insertProduct(SanphamDto sanpham);
	
	public void deleteProduct(String MaSp);
	
	public void updateProduct(SanphamDto sanpham);
	
	public SanphamDto getProductByten(String TenSP);

}
