package quanlykhachhang;

import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quanlynhanvien.NhanVienDemo;
import quanlysanpham.SanphamDemo;
import quanlysanpham.SanphamDetail;

public class KhachHangView extends VBox {
	IKhachHangManager khachHangManager = new IKhachHangManagerImpl();

	public KhachHangView(Stage stage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");

		Label ten = new Label("Ho Ten");
		grid.add(ten, 0, 0);
		ten.getStyleClass().add("label");

		TextField txten = new TextField();
		grid.add(txten, 1, 0);

		Label tendangnhap = new Label("Ten Dang Nhap");
		grid.add(tendangnhap, 2, 0);
		tendangnhap.getStyleClass().add("label");

		TextField txtendangnhap = new TextField();
		grid.add(txtendangnhap, 3, 0);

		Label matkhau = new Label("Mat Khau");
		grid.add(matkhau, 0, 1);
		matkhau.getStyleClass().add("label");

		TextField txmatkhau = new TextField();
		grid.add(txmatkhau, 1, 1);

		Label diachi = new Label("Dia Chi");
		grid.add(diachi, 2, 1);
		diachi.getStyleClass().add("label");

		TextField txdiachi = new TextField();
		grid.add(txdiachi, 3, 1);

		Label lbGender = new Label("Gioi Tinh");
		grid.add(lbGender, 0, 2);
		lbGender.getStyleClass().add("label");

		ToggleGroup toggle = new ToggleGroup();

		Text txGetGender = new Text();
		toggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				if (toggle.getSelectedToggle() != null) {
					RadioButton button = (RadioButton) toggle.getSelectedToggle();
					txGetGender.setText(button.getText());
				}
			}
		});
		RadioButton rdMale = new RadioButton("Male");
		rdMale.setToggleGroup(toggle);

		RadioButton rdFemale = new RadioButton("Female");
		rdFemale.setToggleGroup(toggle);

		HBox genderHBox = new HBox();
		genderHBox.setSpacing(15);
		genderHBox.getChildren().addAll(rdMale, rdFemale);
		grid.add(genderHBox, 1, 2);

		Label email = new Label("Email");
		grid.add(email, 2, 2);
		email.getStyleClass().add("label");

		TextField txemail = new TextField();
		grid.add(txemail, 3, 2);

		Label lbMakh = new Label("Ma kh");
		grid.add(lbMakh, 0, 3);

		TextField txMaKh = new TextField();
		grid.add(txMaKh, 1, 3);

		Label lbSdt = new Label("Sdt");
		grid.add(lbSdt, 2, 3);

		TextField txSdt = new TextField();
		grid.add(txSdt, 3, 3);

		Label lbSearch = new Label("Type here to search ");
		grid.add(lbSearch, 1, 5);

		TextField txSearch = new TextField();
		grid.add(txSearch, 2, 5);

		Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
		Image imgUpdate = new Image(getClass().getResourceAsStream("/delete.png"));
		Image imgDetail = new Image(getClass().getResourceAsStream("/detail.png"));

		Button insert = new Button("Insert");
		insert.setGraphic(new ImageView(imgAdd));
		insert.getStyleClass().add("button");

		Button detail = new Button("Detail");
		detail.setGraphic(new ImageView(imgDetail));
		detail.getStyleClass().add("button");

		Button delete = new Button("Delete");
		delete.setGraphic(new ImageView(imgUpdate));
		delete.getStyleClass().add("button");

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().addAll(insert, detail, delete);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 6, 4, 1);

		TableView<KhachHangDemo> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<KhachHangDemo, Integer> maKHCol = new TableColumn<>("ma khach hang");
		maKHCol.setCellValueFactory(new PropertyValueFactory<>("maKH"));
		maKHCol.setVisible(false);

		TableColumn<KhachHangDemo, String> tenCol = new TableColumn<>("Ho Ten Khach Hang");
		tenCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
		tenCol.setMinWidth(200);
		tenCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tenCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> tendangnhapCol = new TableColumn<>("Ten dang nhap");
		tendangnhapCol.setCellValueFactory(new PropertyValueFactory<>("tendangnhap"));
		tendangnhapCol.setMinWidth(200);
		tendangnhapCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tendangnhapCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> matKhauCol = new TableColumn<>("Mat Khau");
		matKhauCol.setCellValueFactory(new PropertyValueFactory<>("matkhau"));
		matKhauCol.setCellFactory(TextFieldTableCell.forTableColumn());
		matKhauCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> diachiCol = new TableColumn<>("Dia Chi");
		diachiCol.setCellValueFactory(new PropertyValueFactory<>("diachi"));
		diachiCol.setCellFactory(TextFieldTableCell.forTableColumn());
		diachiCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> gioiTinhCol = new TableColumn<>("Gioi Tinh");
		gioiTinhCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		gioiTinhCol.setCellFactory(TextFieldTableCell.forTableColumn());
		gioiTinhCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> sdtCol = new TableColumn<>("So Dien Thoai");
		sdtCol.setCellValueFactory(new PropertyValueFactory<>("sdt"));
		sdtCol.setMinWidth(200);
		sdtCol.setCellFactory(TextFieldTableCell.forTableColumn());
		sdtCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		TableColumn<KhachHangDemo, String> emailCol = new TableColumn<>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		emailCol.setMinWidth(200);
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setOnEditCommit(new EventHandler<CellEditEvent<KhachHangDemo, String>>() {
			public void handle(CellEditEvent<KhachHangDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTen(newValue);
				;
			}
		});

		table.getColumns().addAll(maKHCol, tenCol, tendangnhapCol, matKhauCol, diachiCol, gioiTinhCol, sdtCol,
				emailCol);

		ObservableList<KhachHangDemo> data = FXCollections.observableArrayList(khachHangManager.getAllKhachHang());

		table.setItems(data);
		table.getStyleClass().add("table");

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				KhachHangDemo kh = table.getSelectionModel().getSelectedItem();
			
				if (kh == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Details");
					alert.setContentText("Vui long chon du lieu trong bang");
					alert.showAndWait();
				} else {
					Stage khach = new KhachhangDetail(kh);

					khach.initModality(Modality.WINDOW_MODAL);
					khach.initOwner(stage);
					khach.showAndWait();
				}

			}
		});

		// funtion search

		FilteredList<KhachHangDemo> filterData = new FilteredList<>(data, e -> true);
		txSearch.setOnKeyReleased(e -> {
			txSearch.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
				filterData.setPredicate((Predicate<? super KhachHangDemo>) khachhang -> {
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (khachhang.getMaKH().toString().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getTen().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getTendangnhap().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getMatkhau().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getDiachi().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getSdt().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getGender().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (khachhang.getEmail().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}

					return false;

				});
			});
			SortedList<KhachHangDemo> sortedData = new SortedList<>(filterData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);

		});
		;

		// delete
		delete.setOnAction(event -> {
			ObservableList<KhachHangDemo> allStrings;
			ObservableList<KhachHangDemo> stringSelected;
			allStrings = table.getItems();
			stringSelected = table.getSelectionModel().getSelectedItems();
			if (stringSelected.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please choose the row");
				alert.showAndWait();
			} else {
				stringSelected.forEach(allStrings::remove);
			}

		});

		insert.setOnAction((ActionEvent e) -> {

			data.add(new KhachHangDemo(Integer.valueOf(txMaKh.getText()), txten.getText(), txtendangnhap.getText(),
					txmatkhau.getText(), txdiachi.getText(), txGetGender.getText(), txemail.getText(),
					txSdt.getText()));

		});

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getChildren().addAll(grid, table);
		this.getStylesheets().add("stylesheets.css");

	}
}
