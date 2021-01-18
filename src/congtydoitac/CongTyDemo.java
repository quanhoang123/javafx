package congtydoitac;

import javafx.beans.property.SimpleStringProperty;

public class CongTyDemo {

		private SimpleStringProperty MaCT;
		private SimpleStringProperty Ten;
		private SimpleStringProperty DiaChi;
		private SimpleStringProperty SDT;

		public CongTyDemo() {

			this.MaCT = new SimpleStringProperty();
			this.Ten = new SimpleStringProperty();
			this.DiaChi = new SimpleStringProperty();
			this.SDT = new SimpleStringProperty();
		}

		public CongTyDemo(String MaCT, String Ten, String DiaChi, String SDT) {
			this.MaCT = new SimpleStringProperty(MaCT);
			this.Ten = new SimpleStringProperty(Ten);
			this.DiaChi = new SimpleStringProperty(DiaChi);
			this.SDT = new SimpleStringProperty(SDT);
		}

		public String getMaCT() {
			return this.MaCT.get();
		}
		public void setMaCT(String MaCT) {
			this.MaCT.set(MaCT);
		}
		
		public String getTen() {
			return this.Ten.get();
		}
		public void setTen(String Ten) {
			this.Ten.set(Ten);
		}
		
		public String getDiaChi() {
			return this.DiaChi.get();
		}
		public void setDiaChi(String DiaChi) {
			this.DiaChi.set(DiaChi);
		}
		
		public String getSDT() {
			return this.SDT.get();
		}
		public void setSDT(String SDT) {
			this.SDT.set(SDT);
		}
		

}
