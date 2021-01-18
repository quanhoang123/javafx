package congtydoitac;

import java.util.List;


public interface CongTyDao {
	
	public CongTyDto getCongTyByMaCT(String MaCT);
	
     public List<CongTyDto> getAllCongTy();
	
	public void insertCongTy(CongTyDto congty);
	
	public void deleteCongTy(String MaCT);
	
	public void updateCongTy(CongTyDto congty);
	
	public CongTyDto getCongTyByten(String TenCT);

}
