package quanlynhanvien;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class NhanVienDetailView extends Stage {

	public NhanVienDetailView(NhanVienDemo employee) {

		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));

		Label employeeDetail = new Label("               Thong tin Nhan Vien           ");
		grid.add(employeeDetail, 0, 0, 2, 1);

		Label maSP = new Label("Ma San Pham");
		grid.add(maSP, 0, 1);

		TextField txMasp = new TextField(employee.getMaSP());
		txMasp.setPrefWidth(230);
		grid.add(txMasp, 1, 1);

		Label hoten = new Label("Ho Ten");
		grid.add(hoten, 0, 2);

		TextField txhoten = new TextField(employee.getName());
		grid.add(txhoten, 1, 2);

		Label tuoi = new Label("Ngay Sinh");
		grid.add(tuoi, 0, 3);

		TextField txtuoi = new TextField(employee.getDateOfBirth());
		grid.add(txtuoi, 1, 3);

		Label gioitinh = new Label("Gioi Tinh");
		grid.add(gioitinh, 0, 4);

		TextField txgioitinh = new TextField(employee.getGender());
		grid.add(txgioitinh, 1, 4);

		Label lbPhone = new Label("So Dien Thoai");
		grid.add(lbPhone, 0, 5);

		TextField txPhone = new TextField(employee.getPhoneNumber());
		grid.add(txPhone, 1, 5);

		Label diachi = new Label("Dia Chi");
		grid.add(diachi, 0, 6);

		TextField txDiachi = new TextField(employee.getAddress());
		grid.add(txDiachi, 1, 6);

		Label maViTri = new Label(" Ma Vi Tri");
		grid.add(maViTri, 0, 7);

		TextField txMaviTri = new TextField(employee.getMaViTri());
		grid.add(txMaviTri, 1, 7);

		
		Scene scene = new Scene(grid);

		this.setTitle("Bang Nhan Vien");
		this.setScene(scene);
	}
}
