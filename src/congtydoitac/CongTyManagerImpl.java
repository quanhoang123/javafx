package congtydoitac;

import java.util.ArrayList;
import java.util.List;

public class CongTyManagerImpl implements CongTyManager {
	private CongTyDao congtyDao = new CongTyDaoImpl();

	@Override
	public List<CongTyDemo> getAllCongTy() {
		// TODO Auto-generated method stub
		List<CongTyDto> congty = congtyDao.getAllCongTy();
		List<CongTyDemo> list = new ArrayList<>();
		if(congty!= null) {
			for(CongTyDto dto : congty) {
				CongTyDemo doitac = new CongTyDemo();
				doitac.setMaCT(dto.getMaCT());
				doitac.setTen(dto.getTenCT());
				doitac.setDiaChi(dto.getDiachi());
				doitac.setSDT(dto.getSDT());
				
				list.add(doitac);
			}
		}
		return list;
	}

}
