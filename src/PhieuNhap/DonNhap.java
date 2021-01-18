package PhieuNhap;

public class DonNhap {
	

		private String maPhieuNhap;
		private String maSp;
		private String soLuong;
		private String ngayNhap;
		private String soTien;
		private String maNVNhap;
		
		
		public DonNhap() {
			super();
		}


		public DonNhap(String maPhieuNhap, String maSp, String soLuong, String ngayNhap, String soTien, String maNVNhap) {
			super();
			this.maPhieuNhap = maPhieuNhap;
			this.maSp = maSp;
			this.soLuong = soLuong;
			this.ngayNhap = ngayNhap;
			this.soTien = soTien;
			this.maNVNhap = maNVNhap;
		}


		public String getmaPhieuNhap() {
			return maPhieuNhap;
		}


		public void setmaPhieuNhap(String maPhieuNhap) {
			this.maPhieuNhap = maPhieuNhap;
		}


		public String getmaSp() {
			return maSp;
		}


		public void setmaSp(String maSp) {
			this.maSp = maSp;
		}


		public String getSoLuong() {
			return soLuong;
		}


		public void setSoLuong(String soLuong) {
			this.soLuong = soLuong;
		}


		public String getNgayNhap() {
			return ngayNhap;
		}


		public void setNgayNhap(String ngayNhap) {
			this.ngayNhap = ngayNhap;
		}


		public String getSoTien() {
			return soTien;
		}


		public void setSoTien(String soTien) {
			this.soTien = soTien;
		}


		public String getmNVNhap() {
			return maNVNhap;
		}


		public void setmNVNhap(String maNVNhap) {
			this.maNVNhap = maNVNhap;
		}
			
	}

