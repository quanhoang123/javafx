package vitrivieclam;

import java.util.ArrayList;
import java.util.List;

public class VitrivieclamManagerImpl implements VitrivieclamManager{
	private VitrivieclamDao vitriDao = new VitrivieclamDaoImpl();

	@Override
	public List<VitrivieclamDemo> getAllBan() {
		// TODO Auto-generated method stub
		List<VitrivieclamDto> vitriDto = vitriDao.getAllBan();
		List<VitrivieclamDemo> vitriDemo = new ArrayList<>();
		if(vitriDto != null) {
			for(VitrivieclamDto dto : vitriDto) {
				VitrivieclamDemo vitri = new VitrivieclamDemo();
				vitri.setMaViTri(dto.getMaViTri());
				vitri.setViTriLV(dto.getViTriLV());
				vitri.setLuong(dto.getLuong());
				
				vitriDemo.add(vitri);
			}
		}
		return vitriDemo;
	}

}
