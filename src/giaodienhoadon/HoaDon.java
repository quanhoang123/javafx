package giaodienhoadon;

import java.util.Optional;

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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class HoaDon extends VBox{
	
	
	public HoaDon(Stage stage) throws Exception {
		// TODO Auto-generated method stub

	GridPane grid = new GridPane();
	grid.setPadding(new Insets(20,20,20,20));
	grid.getStyleClass().add("grid");
	grid.setHgap(15);
	grid.setVgap(15);
	
	Label ten = new Label("Hoa Don");
	ten.getStyleClass().add("title");
	GridPane.setConstraints(ten, 0, 0, 4, 1, HPos.CENTER, VPos.BOTTOM);
	grid.add(ten, 0, 0);
	
	Label teKH = new Label ("Ten Khach Hang : ");
	teKH.setFont(Font.font("Times New Roman",15));
	teKH.getStyleClass().add("label");
	grid.add(teKH, 0, 1);
	
	Label diachi = new Label ("Dia Chi Khach Hang : ");
	diachi.setFont(Font.font("Times New Roman",15));
	diachi.getStyleClass().add("label");
	grid.add(diachi, 0, 2);
	

	Label sdt = new Label ("SDT Khach Hang : ");
	sdt.setFont(Font.font("Times New Roman",15));
	sdt.getStyleClass().add("label");
	grid.add(sdt, 0, 3);
	
	Label maSP = new Label ("Ma San Pham : ");
	maSP.setFont(Font.font("Times New Roman",15));
	maSP.getStyleClass().add("label");
	grid.add(maSP, 2, 1);
	
	Label tenSP = new Label ("Ten San Pham : ");
	tenSP.setFont(Font.font("Times New Roman",15));
	tenSP.getStyleClass().add("label");
	grid.add(tenSP, 2, 2);
	
	Label sl = new Label ("So Luong San Pham : ");
	sl.setFont(Font.font("Times New Roman",15));
	sl.getStyleClass().add("label");
	grid.add(sl, 2, 3);
	
	Label gia = new Label ("Gia San Pham : ");
	gia.setFont(Font.font("Times New Roman",15));
	gia.getStyleClass().add("label");
	grid.add(gia, 0, 4);
	
	Label total = new Label ("Tong cong : ");
	total.setFont(Font.font("Times New Roman",15));
	total.getStyleClass().add("label");
	grid.add(total, 1, 5);
	
	TextField txTenKH = new TextField("");
	txTenKH.setPrefWidth(200);
	grid.add(txTenKH, 1, 1);
	
	TextField txdiachi = new TextField("");
	txdiachi.setPrefWidth(200);
	grid.add(txdiachi, 1, 2);
	
	TextField txSdt = new TextField("");
	txSdt.setPrefWidth(200);
	grid.add(txSdt, 1, 3);
	
	TextField txMasp = new TextField("");
	txMasp.setPrefWidth(200);
	grid.add(txMasp, 3, 1);
	
	TextField txTensp = new TextField("");
	txTensp.setPrefWidth(200);
	grid.add(txTensp, 3, 2);
	
	TextField txSL = new TextField("");
	txSL.setPrefWidth(200);
	grid.add(txSL, 3, 3);
	
	TextField txGia = new TextField("");
	txGia.setPrefWidth(200);
	grid.add(txGia, 1, 4);
	
	TextField txTotal = new TextField("");
	txTotal.setPrefWidth(200);
	grid.add(txTotal, 2, 5);
	
	Image tinh = new Image(getClass().getResourceAsStream("/calculator.png"));
	Image xoa = new Image(getClass().getResourceAsStream("/cancel.png"));
	
	Button bt1 = new Button("Tinh");
    bt1.setFont(Font.font("Times New Roman",15));
    bt1.setGraphic(new ImageView(tinh));
    bt1.getStyleClass().add("bt1");
    grid.add(bt1, 1, 7);
    GridPane.setConstraints(bt1, 1, 7, 1, 1, HPos.LEFT, VPos.BOTTOM);
    
    Button bt = new Button("Xoa");
    bt.setFont(Font.font("Times New Roman",15));
    bt.setGraphic(new ImageView(xoa));
    bt.getStyleClass().add("bt");
    grid.add(bt, 2, 7);
    GridPane.setConstraints(bt, 2, 7, 1, 1, HPos.LEFT, VPos.BOTTOM);
    
    txSL.setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent keyEvent) {
			try {
				Double.valueOf(keyEvent.getText());
			} catch (NumberFormatException ex) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Chu y");
				alert.setHeaderText(null);
				alert.setContentText("Vui Long Nhap So!");
				alert.showAndWait();
			}}
    });
    
    txGia.setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent keyEvent) {
			try {
				Double.valueOf(keyEvent.getText());
			} catch (NumberFormatException ex) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Chu y");
				alert.setHeaderText(null);
				alert.setContentText("Vui Long Nhap So!");
				alert.showAndWait();
			}}
	});
    
    bt1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		
		public void handle(ActionEvent event) {
			try {
				if(txGia.getText().isEmpty()||txSL.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Nhap gia va so luong san pham!");
					alert.showAndWait();
				}	else {
					Double a = Double.valueOf(txGia.getText());
					Double b = Double.valueOf(txSL.getText());
						Double kq = (double)(a*b);
						txTotal.setText(kq.toString());
					}
					
			}catch (NumberFormatException ex) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("error");
				alert.setHeaderText(null);
				alert.setContentText("Vui long nhap so!");
				alert.showAndWait();
			}
		}});
    
    txGia.setOnKeyPressed(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent key) {
			// TODO Auto-generated method stub
			if(key.getCode() == KeyCode.ENTER) {
				try {
					if(txGia.getText().isEmpty()||txSL.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information");
						alert.setHeaderText(null);
						alert.setContentText("Nhap gia va so luong san pham!");
						alert.showAndWait();
					}	else {
						Double a = Double.valueOf(txGia.getText());
						Double b = Double.valueOf(txSL.getText());
							Double kq = (double)(a*b);
							txTotal.setText(kq.toString());
						}
						
				}catch (NumberFormatException ex) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("error");
					alert.setHeaderText(null);
					alert.setContentText("Vui long nhap so!");
					alert.showAndWait();
				}
			}}
			});
    
    bt.setOnMousePressed(new EventHandler<MouseEvent>() {
		public void handle(MouseEvent mouseEvent) {
			txdiachi.setText("");
			txSdt.setText("");
			txTotal.setText("");
			txMasp.setText("");
			txTensp.setText("");
			txGia.setText("");
			txSL.setText("");
			txTenKH.setText("");
		}
	});
    
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		@Override
		public void handle(WindowEvent windowEvent) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText(null);
			alert.setContentText("Ban muon thoat khoi?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {

			} else {
				windowEvent.consume();
			}
		}

	});
    
    Image n = new Image(getClass().getResourceAsStream("/receipt.png"));
	Scene sc = new Scene(grid);
	sc.getStylesheets().add("Stylesheets.css");
	stage.setTitle("Hoa Don");
	stage.getIcons().add(n);
	stage.setScene(sc);
	stage.show();
	}
	

}
