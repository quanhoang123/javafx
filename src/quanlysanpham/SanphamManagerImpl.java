package quanlysanpham;

import java.util.ArrayList;
import java.util.List;

public class SanphamManagerImpl implements SanphamManager{
	
	private SanphamDao sanphamDao = new SanphamDaoImpl();

	@Override
	public List<SanphamDemo> getAllProductes() {
		// TODO Auto-generated method stub
		List<SanphamDto> sanphamDto = sanphamDao.getAllProductes();
		List<SanphamDemo> list = new ArrayList<>();
		if(sanphamDto != null) {
			for(SanphamDto dto : sanphamDto) {
				SanphamDemo sp = new SanphamDemo();
				sp.setMaSP(dto.getMaSp());
				sp.setTenSP(dto.getTenSP());
				sp.setMaCT(dto.getMaCT());
				sp.setGiaSP(dto.getGiaSP());
				sp.setTinhTrang(dto.getTinhTrang());
				sp.setNhanXet(dto.getNhanXet());
				
				list.add(sp);
			}
		}
		return list;
	}

}
