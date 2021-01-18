package vitrivieclam;

import java.util.List;


public interface VitrivieclamDao {
	
public VitrivieclamDto getBanByMasp(String MaViTri);
	
	public List<VitrivieclamDto> getAllBan();
	
	public void insertBan(VitrivieclamDto ban);
	
	public void deleteBan(String MaViTri);
	
	public void updateBan(VitrivieclamDto ban);
	
	public VitrivieclamDto getBanByten(String ViTriLV);

}
