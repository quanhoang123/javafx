package quanlysanpham;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SanphamDetail extends Stage{

	public SanphamDetail(SanphamDemo product) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));
		
		Label title = new Label("          Chi Tiet San Pham");
		GridPane.setConstraints(title, 0, 0, 2, 1,HPos.CENTER,VPos.BOTTOM);
		
		Label masp = new Label("Ma San Pham");
		grid.add(masp, 0, 1);
		
		TextField txmasp = new TextField(product.getMaSP());
		grid.add(txmasp, 1, 1);
		
		Label tenSp = new Label("Ten San Pham");
		grid.add(tenSp, 0, 2);
		
		TextField txtenSp = new TextField(product.getTenSP());
		grid.add(txtenSp, 1, 2);
		
		Label maCT = new Label("Ma Cong Ty cung cap");
		grid.add(maCT, 0, 3);
		
		TextField txmaCT = new TextField(product.getMaCT());
		grid.add(txtenSp, 1, 3);
		
		Label gia = new Label("Gia San Pham");
		grid.add(gia, 0, 4);
		
		TextField txGia = new TextField(product.getGiaSP());
		grid.add(txGia, 1, 4);
		
		Label tinhTrang = new Label("Tinh Trang San Pham");
		grid.add(tinhTrang, 0, 5);
		
		TextField txtinhTrang = new TextField(product.getTinhTrang());
		grid.add(txtinhTrang, 1, 5);
		
		Label nhanxet = new Label("Nhan Xet San Pham");
		grid.add(tenSp, 0, 6);
		
		TextField txNx = new TextField(product.getNhanXet());
		grid.add(txNx, 1, 6);
		
		Scene scene = new Scene(grid);

		this.setTitle("Bang San Pham");
		this.setScene(scene);
		
	}
	

}
