package Login;

import java.util.Optional;

import quanlikitucxa.DanhSachSP;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import quanlykhachhang.Phieu_DangNhapKH;

public class Phieu_DangKi extends VBox{
	
	
	public Phieu_DangKi(Stage stage)  {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(20);
		grid.setVgap(20);
		grid.getStyleClass().add("grid");
		
		Label title = new Label("Sign up");
		GridPane.setConstraints(title, 0, 0, 4, 1, HPos.CENTER, VPos.BOTTOM);
		grid.add(title, 0, 0);
		title.getStyleClass().add("name");
		
		Label ten = new Label("Ho va ten : ");
		grid.add(ten, 0, 1);
		ten.getStyleClass().add("label");
		
		Label tenDN = new Label("Ten dang nhap : ");
		grid.add(tenDN, 2, 1);
		tenDN.getStyleClass().add("label");
		
		Label mk = new Label("Nhap mat khau : ");
		grid.add(mk,0 , 2);
		mk.getStyleClass().add("label");
		
		Label nhapMk = new Label("Nhap lai mat khau : ");
		grid.add(nhapMk, 2, 2);
		nhapMk.getStyleClass().add("label");
		
		Label diachi = new Label("Dia Chi : ");
		grid.add(diachi, 0, 3);
		diachi.getStyleClass().add("label");
		
		Label email = new Label("Email : ");
		grid.add(email, 2, 3);
		email.getStyleClass().add("label");
		
		Label sdt = new Label("So Dien Thoai : ");
		grid.add(sdt, 0, 4);
		sdt.getStyleClass().add("label");
		
		Label gioiTinh = new Label("Gioi Tinh : ");
		grid.add(gioiTinh, 2, 4);
		gioiTinh.getStyleClass().add("label");
		
		TextField txTen = new TextField();
		txTen.setPrefWidth(300);
		grid.add(txTen, 1, 1);
		
		TextField txTenDangN = new TextField();
		txTenDangN.setPrefWidth(300);
		grid.add(txTenDangN, 3, 1);
		
		PasswordField txMk = new PasswordField();
		txMk.setPrefWidth(300);
		grid.add(txMk, 1, 2);
		
		PasswordField txNhapMk = new PasswordField();
		txNhapMk.setPrefWidth(300);
		grid.add(txNhapMk, 3, 2);
		
		TextField txDiachi = new TextField();
		txDiachi.setPrefWidth(200);
		grid.add(txDiachi, 1, 3);
		
		TextField txemail = new TextField();
		grid.add(txemail,3 , 3);
		
		TextField txSdt = new TextField();
		grid.add(txSdt,1 , 4);
		
		final ToggleGroup group = new ToggleGroup();
		RadioButton male = new RadioButton("Male");
		male.setUserData("Male");
		male.setToggleGroup(group);
		GridPane.setConstraints(male, 3, 4, 1, 1, HPos.LEFT, VPos.BOTTOM);
		grid.add(male, 3, 4);
		male.getStyleClass().add("gender");
		
		RadioButton female = new RadioButton("Female");
		female.setUserData("Female");
		female.setToggleGroup(group);
		GridPane.setConstraints(female, 3, 4, 1, 1, HPos.RIGHT, VPos.BOTTOM);
		grid.add(female, 3, 4);
		female.getStyleClass().add("gender");
		
		Button login = new Button("Login");
		login.setPrefWidth(100);
		login.setPrefHeight(20);
		GridPane.setConstraints(login, 1, 5, 1, 1, HPos.RIGHT, VPos.BOTTOM);
		grid.add(login, 1, 5);
		login.getStyleClass().add("login");
		
		Button can = new Button("Cancel");
		can.setPrefWidth(100);
		can.setPrefHeight(20);
		GridPane.setConstraints(can, 2, 5, 1, 1, HPos.LEFT, VPos.BOTTOM);
		grid.add(can, 2, 5);
		can.getStyleClass().add("can");
		
		
		login.setOnAction(new EventHandler<ActionEvent>() {
		    @SuppressWarnings("unlikely-arg-type")
			@Override
		    public void handle(ActionEvent event) {
		        if(txTen.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap ten");
		            return;
		        }
		        if(txemail.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap email");
		            return;
		        }
		        if(txMk.getText().isEmpty()) {
		        	if (txMk.equals(txMk.getText()) && txNhapMk.equals(txNhapMk.getText())) {

					}

		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap mat khau");
		            return;
		        }
		        
		        if(txNhapMk.getText().isEmpty()) {
		        	if(txMk.equals(mk)&& txNhapMk.equals(nhapMk)) {
		        	
		        	}
		        	
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap lai mat khau");
		            return;
		        }
		        if(txDiachi.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap dia chi");
		            return;
		        }
		        if(txSdt.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap so dien thoai");
		            return;
		        }
		        if(txTenDangN.getText().isEmpty()) {
		            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
		            "Form Error!", "vui long nhap ten dang nhap");
		            return;
		        }
		       

		        showAlert(Alert.AlertType.CONFIRMATION, grid.getScene().getWindow(), 
		        " dang ki thanh cong!"," chao mung ban  " + txTen.getText()+" den voi shop ");   
		       
		        new DanhSachSP(stage);
		    }
		      
		    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		        Alert alert = new Alert(alertType);
		        alert.setTitle(title);
		        alert.setHeaderText(null);
		        alert.setContentText(message);
		        alert.initOwner(owner);
		        alert.showAndWait();
		        
		        alert.close();
		    }
		
		});
	
		can.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Ban Khong Muon Dang Ky Tai Khoan ?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

				} 
				
				stage.close();
			}

			
		});
		
		
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Ban muon thoat ?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

				} else {
					windowEvent.consume();
				}
			}

		});
	
	
		
		Scene scene = new Scene(grid);
		stage.setTitle("Dang Ki");
		scene.getStylesheets().add("stylesheets.css");
		stage.setScene(scene);
		stage.show();
		
	}

}
