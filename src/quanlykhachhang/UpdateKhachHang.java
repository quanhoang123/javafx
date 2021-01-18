package quanlykhachhang;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UpdateKhachHang extends Stage {
	
	public UpdateKhachHang(KhachHangDemo khachhang) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Label lbInfo = new Label(" Cap nhat khach hang");
		grid.add(lbInfo, 0, 0, 2, 1);
		
		Label ten = new Label("Ho Ten");
		grid.add(ten, 0, 2);
		
		TextField txten = new TextField(khachhang.getTen());
		grid.add(txten, 1, 2);

		Label tendangnhap = new Label("Ten Dang Nhap");
		grid.add(tendangnhap, 0, 3);
		

		TextField txtendangnhap = new TextField(khachhang.getTendangnhap());
		grid.add(txtendangnhap, 1, 3);

		Label matkhau = new Label("Mat Khau");
		grid.add(matkhau, 0, 4);
		

		TextField txmatkhau = new TextField(khachhang.getMatkhau());
		grid.add(txmatkhau, 1, 4);

		Label diachi = new Label("Dia Chi");
		grid.add(diachi, 0, 5);
		

		TextField txdiachi = new TextField(khachhang.getDiachi());
		grid.add(txdiachi, 1, 5);

		Label lbGender = new Label("Gioi Tinh");
		grid.add(lbGender, 0, 6);
		
		
       ToggleGroup toggleGroup = new ToggleGroup();
		
		RadioButton male = new RadioButton("Male");
		male.setToggleGroup(toggleGroup);
		
		RadioButton female = new RadioButton("Female");
		female.setToggleGroup(toggleGroup);
		
		if ("nam".equals(khachhang.getGender())) {
			male.setSelected(true);
		} else {
			female.setSelected(true);
		}
		
		HBox hbGender = new HBox();
		hbGender.setSpacing(15);
		hbGender.getChildren().addAll(male, female);
		grid.add(hbGender, 1, 6);
		
		Label email = new Label("Email");
		grid.add(email, 0, 7);
		

		TextField txemail = new TextField(khachhang.getEmail());
		grid.add(txemail, 1, 7);
		
        Button update = new Button("Update");
		
		Button clear = new Button("Clear");
		
		HBox hbox = new HBox();
		hbox.setSpacing(25);
		hbox.getChildren().addAll(update, clear);
		grid.add(hbox, 1, 9);
		
		Scene scene = new Scene(grid);
		
		this.setTitle("Cap nhat khach hang");
		this.setScene(scene);

	}

}
