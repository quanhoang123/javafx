package quanlykhachhang;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KhachhangDetail extends Stage{
	public KhachhangDetail(KhachHangDemo kh) {
	
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(15, 15, 15, 15));
	grid.setHgap(15);
	grid.setVgap(15);
	grid.getStyleClass().add("grid");
	

	Label khachhang = new Label("Khach Hang");
	khachhang.setFont(new Font("Times new roman", 23));
	grid.add(khachhang, 0, 0, 2, 1);

	Label ten = new Label("Ho Ten");
	grid.add(ten, 0, 2);

	TextField txten = new TextField(kh.getTen());
	grid.add(txten, 1, 2);

	Label tendangnhap = new Label("Ten Dang Nhap");
	grid.add(tendangnhap, 0, 3);

	TextField txtendangnhap = new TextField(kh.getTendangnhap());
	grid.add(txtendangnhap, 1, 3);

	Label matkhau = new Label("Mat Khau");
	grid.add(matkhau, 0, 4);

	TextField txmatkhau = new TextField(kh.getMatkhau());
	grid.add(txmatkhau, 1, 4);

	Label diachi = new Label("Dia Chi");
	grid.add(diachi, 0, 5);

	TextField txdiachi = new TextField(kh.getDiachi());
	grid.add(txdiachi, 1, 5);

	Label lbGender = new Label("Gioi Tinh");
	grid.add(lbGender, 0, 6);

	TextField txGender = new TextField(kh.getGender());
	grid.add(txGender, 1, 6);

	Label email = new Label("Email");
	grid.add(email, 0, 7);

	TextField txemail = new TextField(kh.getEmail());
	grid.add(txemail, 1, 7);
	
	Scene scene = new Scene(grid);

	this.setTitle("Khach Hang");
	this.setScene(scene);
	}

}
