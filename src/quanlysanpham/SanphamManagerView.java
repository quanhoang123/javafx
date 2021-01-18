package quanlysanpham;

import java.util.function.Predicate;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import quanlykhachhang.KhachHangDemo;
import quanlynhanvien.NhanVienDemo;
import quanlynhanvien.NhanVienDetailView;

public class SanphamManagerView extends VBox {

	private SanphamManager spManager = new SanphamManagerImpl();

	public SanphamManagerView(Stage stage) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.getStyleClass().add("grid");

		Label masp = new Label("Ma San Pham");
		grid.add(masp, 0, 1);
		masp.getStyleClass().add("label");

		TextField txmasp = new TextField();
		grid.add(txmasp, 1, 1);

		Label tenSp = new Label("Ten San Pham");
		grid.add(tenSp, 2, 1);
		tenSp.getStyleClass().add("label");

		TextField txtenSp = new TextField();
		grid.add(txtenSp, 3, 1);

		Label maCT = new Label("Ma Cong Ty cung cap");
		grid.add(maCT, 0, 2);
		maCT.getStyleClass().add("label");

		TextField txmaCT = new TextField();
		grid.add(txmaCT, 1, 2);

		Label gia = new Label("Gia San Pham");
		grid.add(gia, 2, 2);
		gia.getStyleClass().add("label");

		TextField txGia = new TextField();
		grid.add(txGia, 3, 2);

		Label tinhTrang = new Label("Tinh Trang San Pham");
		grid.add(tinhTrang, 0, 3);
		tinhTrang.getStyleClass().add("label");

		TextField txtinhTrang = new TextField();
		grid.add(txtinhTrang, 1, 3);

		Label nhanxet = new Label("Nhan Xet San Pham");
		grid.add(nhanxet, 2, 3);
		nhanxet.getStyleClass().add("label");

		TextField txNx = new TextField();
		grid.add(txNx, 3, 3);

		Label lbSearch = new Label("Type here to search ");
		grid.add(lbSearch, 1, 4);

		TextField txSearch = new TextField();
		grid.add(txSearch, 2, 4);

		Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
		Image imgUpdate = new Image(getClass().getResourceAsStream("/delete.png"));
		Image imgDetail = new Image(getClass().getResourceAsStream("/detail.png"));

		Button insert = new Button("Insert");
		insert.setGraphic(new ImageView(imgAdd));
		insert.getStyleClass().add("button");

		

		Button delete = new Button("Delete");
		delete.setGraphic(new ImageView(imgUpdate));
		delete.getStyleClass().add("button");

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().addAll(insert, delete);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 5, 4, 1);

		TableView<SanphamDemo> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<SanphamDemo, String> maSp = new TableColumn<>("Ma San Pham");
		maSp.setCellValueFactory(new PropertyValueFactory<>("MaSP"));
		maSp.setMinWidth(100);
		maSp.setCellFactory(TextFieldTableCell.forTableColumn());
		maSp.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setMaSP(newValue);
			}

		});

		TableColumn<SanphamDemo, String> tenCol = new TableColumn<>("Ten San Pham");
		tenCol.setCellValueFactory(new PropertyValueFactory<>("TenSP"));
		tenCol.setMinWidth(200);
		tenCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tenCol.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTenSP(newValue);
				;
			}

		});

		TableColumn<SanphamDemo, String> mactCol = new TableColumn<>("Ma Cong ty cung cap");
		mactCol.setCellValueFactory(new PropertyValueFactory<>("MaCT"));
		mactCol.setMinWidth(200);
		mactCol.setCellFactory(TextFieldTableCell.forTableColumn());
		mactCol.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setMaCT(newValue);
				;
			}

		});

		TableColumn<SanphamDemo, String> giaCol = new TableColumn<>("Gia San Pham");
		giaCol.setCellValueFactory(new PropertyValueFactory<>("GiaSP"));
		giaCol.setMinWidth(100);
		giaCol.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setGiaSP(newValue);
				;
			}

		});

		TableColumn<SanphamDemo, String> tinhTrangCol = new TableColumn<>("Tinh Trang");
		tinhTrangCol.setCellValueFactory(new PropertyValueFactory<>("TinhTrang"));
		tinhTrangCol.setMinWidth(200);
		tinhTrangCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tinhTrangCol.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setTinhTrang(newValue);
				;
			}

		});

		TableColumn<SanphamDemo, String> nhanxetCol = new TableColumn<>("Nhan Xet");
		nhanxetCol.setCellValueFactory(new PropertyValueFactory<>("NhanXet"));
		nhanxetCol.setMinWidth(100);
		nhanxetCol.setCellFactory(TextFieldTableCell.forTableColumn());
		nhanxetCol.setOnEditCommit(new EventHandler<CellEditEvent<SanphamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<SanphamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setNhanXet(newValue);
				;
			}

		});

		table.getColumns().addAll(maSp, tenCol, mactCol, giaCol, tinhTrangCol, nhanxetCol);

		ObservableList<SanphamDemo> data = FXCollections.observableArrayList(spManager.getAllProductes());

		table.setItems(data);
		table.getStyleClass().add("table");

		// funtion search

		FilteredList<SanphamDemo> filterData = new FilteredList<>(data, e -> true);
		txSearch.setOnKeyReleased(e -> {
			txSearch.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
				filterData.setPredicate((Predicate<? super SanphamDemo>) sanpham -> {
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();
					if (sanpham.getMaSP().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (sanpham.getTenSP().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (sanpham.getMaCT().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (sanpham.getGiaSP().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (sanpham.getTinhTrang().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (sanpham.getNhanXet().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}

					return false;

				});
			});
			SortedList<SanphamDemo> sortedData = new SortedList<>(filterData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);

		});
		;

		// delete
		delete.setOnAction(event -> {
			ObservableList<SanphamDemo> allStrings;
			ObservableList<SanphamDemo> stringSelected;
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

			data.add(new SanphamDemo(txmasp.getText(), txtenSp.getText(), txmaCT.getText(), txGia.getText(),
					txtinhTrang.getText(), txNx.getText()));

		});

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getStylesheets().add("stylesheets.css");
		this.getChildren().addAll(grid, table);

	}

}
