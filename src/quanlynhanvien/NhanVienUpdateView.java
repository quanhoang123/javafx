package quanlynhanvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class NhanVienUpdateView extends Stage {
	public NhanVienUpdateView(NhanVienDemo employee) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));

		Label lbInfo = new Label("Cap Nhat Nhan Vien");
		grid.add(lbInfo, 0, 0, 2, 1);

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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(employee.getDateOfBirth(), formatter);

		DatePicker dateOfBirth = new DatePicker(localDate);
		dateOfBirth.setPrefWidth(txhoten.getPrefWidth());
		grid.add(dateOfBirth, 1, 3);

		Label gioitinh = new Label("Gioi Tinh");
		grid.add(gioitinh, 0, 4);

        ToggleGroup toggleGroup = new ToggleGroup();
		
		RadioButton male = new RadioButton("Nam");
		male.setToggleGroup(toggleGroup);
		
		RadioButton female = new RadioButton("Nu");
		female.setToggleGroup(toggleGroup);
		
		if ("Nam".equals(employee.getGender())) {
			male.setSelected(true);
		} else {
			female.setSelected(true);
		}
		
		HBox hbGender = new HBox();
		hbGender.setSpacing(15);
		hbGender.getChildren().addAll(male, female);
		grid.add(hbGender, 1, 6);	

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
	

		
		Button update = new Button("Update");
		
		Button clear = new Button("Clear");
		
		HBox hbox = new HBox();
		hbox.setSpacing(25);
		hbox.getChildren().addAll(update, clear);
		grid.add(hbox, 1, 9);
		
		Scene scene = new Scene(grid);
		
		this.setTitle("Employee Update");
		this.setScene(scene);
	}

}
