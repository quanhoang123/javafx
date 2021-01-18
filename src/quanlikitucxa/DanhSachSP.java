package quanlikitucxa;

import Login.Phieu_DangNhap;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quanlykhachhang.Phieu_DangNhapKH;

public class DanhSachSP extends VBox {

	public DanhSachSP(Stage stage) {
		
		Stage st = new Phieu_DangNhapKH();
		st.initModality(Modality.WINDOW_MODAL);
		st.initOwner(stage);
		st.showAndWait();

		if (Phieu_DangNhapKH.stateLogin) {
			stage.show();
		}

		ListView<String> list = new ListView<>();
		list.setPrefWidth(200);
		ObservableList<String> items = FXCollections.observableArrayList("Danh Sach Mat Hang", "Ao Dai", "Quan Vai",
				"Ao Trang", "Vay", "Dam", "Quan Dai", "Ao Coc", "Quan Jean", "Ao Bulls", "So Mi", "Chan Vay");
		list.setItems(items);

		VBox vbox = new Menu(stage);
		VBox vbox1 = new AoDai(stage);
		VBox vbox2 = new QuanVai(stage);
		VBox vbox3 = new AoTrang(stage);
		VBox vbox4 = new Vay(stage);
		VBox vbox5 = new Dam(stage);
		VBox vbox6 = new QuanDai(stage);
		VBox vbox7 = new AoCoc(stage);
		VBox vbox8 = new QuanJean(stage);
		VBox vbox9 = new AoBun(stage);
		VBox vbox10 = new SoMi(stage);
		VBox vbox11 = new ChanVay(stage);
		
		
		BorderPane border = new BorderPane();
		border.setLeft(list);
		border.setCenter(vbox);
		border.setPrefHeight(500);
		border.setPrefWidth(600);
		border.setPadding(new Insets(0, 0, 10, 0));

		list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				System.out.println("value: " + newValue);
				if ("0".equals(newValue.toString())) {
					border.setCenter(vbox);
					vbox.setVisible(true);
				}

				if ("1".equals(newValue.toString())) {
					border.setCenter(vbox1);
					vbox1.setVisible(true);
					
				}

				if ("2".equals(newValue.toString())) {
					border.setCenter(vbox2);
					vbox2.setVisible(true);
				}

				if ("2".equals(newValue.toString())) {
					border.setCenter(vbox2);
					vbox2.setVisible(true);
				}
				
				if ("3".equals(newValue.toString())) {
					border.setCenter(vbox3);
					vbox3.setVisible(true);
				}
				
				if ("4".equals(newValue.toString())) {
					border.setCenter(vbox4);
					vbox4.setVisible(true);
				}
				
				if ("5".equals(newValue.toString())) {
					border.setCenter(vbox5);
					vbox5.setVisible(true);
				}
				
				if ("6".equals(newValue.toString())) {
					border.setCenter(vbox6);
					vbox6.setVisible(true);
				}
				
				if ("7".equals(newValue.toString())) {
					border.setCenter(vbox7);
					vbox7.setVisible(true);
				}
				
				if ("8".equals(newValue.toString())) {
					border.setCenter(vbox8);
					vbox8.setVisible(true);
				}
				
				if ("9".equals(newValue.toString())) {
					border.setCenter(vbox9);
					vbox9.setVisible(true);
				}
				
				if ("10".equals(newValue.toString())) {
					border.setCenter(vbox10);
					vbox10.setVisible(true);
				}
				
				if ("11".equals(newValue.toString())) {
					border.setCenter(vbox11);
					vbox11.setVisible(true);
				}
			}
		});
		list.getStyleClass().add("list");

		Scene scene = new Scene(border);
		scene.getStylesheets().add("stylesheets.css");

		stage.setTitle("             Chi Tiet San Pham         ");
		stage.setScene(scene);
		
		

	}

	
}
