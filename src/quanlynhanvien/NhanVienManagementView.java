package quanlynhanvien;

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
import javafx.scene.control.DatePicker;
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

public class NhanVienManagementView extends VBox {

	private NhanVienManager employeeManager = new NhanVienManagerImpl();

	public NhanVienManagementView(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(12, 12, 12, 12));
		grid.getStyleClass().add("grid");

		Label MaSp = new Label("Ma san pham :");
		grid.add(MaSp, 0, 0);
		MaSp.getStyleClass().add("label");

		TextField txMaSp = new TextField();
		txMaSp.setPrefWidth(230);
		grid.add(txMaSp, 1, 0);

		Label ten = new Label("Ho Ten:");
		grid.add(ten, 2, 0);
		ten.getStyleClass().add("label");

		TextField txTen = new TextField();
		txTen.setPrefWidth(230);
		grid.add(txTen, 3, 0);

		Label lbDateOfBirth = new Label("Ngay Sinh: ");
		grid.add(lbDateOfBirth, 0, 1);
		lbDateOfBirth.getStyleClass().add("label");

		DatePicker dateOfBirth = new DatePicker();
		dateOfBirth.setPrefWidth(txTen.getPrefWidth());
		grid.add(dateOfBirth, 1, 1);

		Label lbGender = new Label("Gioi Tinh");
		grid.add(lbGender, 2, 1);
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

		RadioButton rdMale = new RadioButton("Nam");
		rdMale.setToggleGroup(toggle);

		RadioButton rdFemale = new RadioButton("Nu");
		rdFemale.setToggleGroup(toggle);

		HBox genderHBox = new HBox();
		genderHBox.setSpacing(15);
		genderHBox.getChildren().addAll(rdMale, rdFemale);
		grid.add(genderHBox, 3, 1);

		Label lbPhone = new Label("So Dien Thoai");
		grid.add(lbPhone, 0, 2);
		lbPhone.getStyleClass().add("label");

		TextField txPhone = new TextField();
		grid.add(txPhone, 1, 2);

		Label diachi = new Label("Dia Chi");
		grid.add(diachi, 2, 2);
		diachi.getStyleClass().add("label");

		TextField txdiachi = new TextField();
		grid.add(txdiachi, 3, 2);

		Label vitri = new Label("Ma Vi Tri:");
		grid.add(vitri, 0, 3);
		vitri.getStyleClass().add("label");

		TextField txViTri = new TextField();
		grid.add(txViTri, 1, 3);

		Label lbSearch = new Label("Type here to search ");
		grid.add(lbSearch, 1, 5);

		TextField txSearch = new TextField();
		grid.add(txSearch, 2, 5);

		Label lbMaNv = new Label("Ma NV");
		grid.add(lbMaNv, 2, 3);

		TextField txMaNv = new TextField();
		grid.add(txMaNv, 3, 3);

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

		TableView<NhanVienDemo> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<NhanVienDemo, Integer> maNV = new TableColumn<>("Ma Nhan Vien");
		maNV.setMinWidth(100);
		maNV.setCellValueFactory(new PropertyValueFactory<>("MaNV"));
		maNV.setVisible(false);

		TableColumn<NhanVienDemo, String> maSp = new TableColumn<>("Ma San Pham");
		maSp.setCellValueFactory(new PropertyValueFactory<>("MaSP"));
		maSp.setMinWidth(100);
		maSp.setCellFactory(TextFieldTableCell.forTableColumn());
		maSp.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setMaSP(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> tenCol = new TableColumn<>("Ho Ten Nhan Vien");
		tenCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		tenCol.setMinWidth(200);
		tenCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tenCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setName(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> diachiCol = new TableColumn<>("Dia Chi");
		diachiCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		diachiCol.setMinWidth(100);
		diachiCol.setCellFactory(TextFieldTableCell.forTableColumn());
		diachiCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAddress(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> dateOfBirthCol = new TableColumn<>("Ngay Sinh");
		dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
		dateOfBirthCol.setMinWidth(100);
		dateOfBirthCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setDateOfBirth(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> phoneNumberCol = new TableColumn<>("So Dien Thoai");
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		phoneNumberCol.setMinWidth(200);
		phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
		phoneNumberCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setPhoneNumber(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> genderCol = new TableColumn<>("Gioi Tinh");
		genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
		genderCol.setMinWidth(100);
		genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
		genderCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setGender(newValue);
			}

		});

		TableColumn<NhanVienDemo, String> addressCol = new TableColumn<>("Dia Chi");
		addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
		addressCol.setMinWidth(100);
		addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
		addressCol.setOnEditCommit(new EventHandler<CellEditEvent<NhanVienDemo, String>>() {
			@Override
			public void handle(CellEditEvent<NhanVienDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setAddress(newValue);
			}

		});

		table.getColumns().addAll(maNV, maSp, tenCol, diachiCol, dateOfBirthCol, phoneNumberCol, genderCol, addressCol);

		ObservableList<NhanVienDemo> data = FXCollections.observableArrayList(employeeManager.getAllEmployees());

		table.setItems(data);
		table.getStyleClass().add("table");

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				NhanVienDemo employee = table.getSelectionModel().getSelectedItem();
			
				if (employee == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Employee Details");
					alert.setContentText("Vui long chon du lieu trong bang");
					alert.showAndWait();
				} else {
					Stage employeeDetailStage = new NhanVienDetailView(employee);

					employeeDetailStage.initModality(Modality.WINDOW_MODAL);
					employeeDetailStage.initOwner(primaryStage);
					employeeDetailStage.showAndWait();
				}

			}
		});

		

		// funtion search

		FilteredList<NhanVienDemo> filterData = new FilteredList<>(data, e -> true);
		txSearch.setOnKeyReleased(e -> {
			txSearch.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
				filterData.setPredicate((Predicate<? super NhanVienDemo>) nhanvien -> {
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();
					if (nhanvien.getMaNV().toString().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getMaSP().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getName().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getDateOfBirth().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getGender().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getAddress().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getPhoneNumber().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (nhanvien.getMaViTri().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}

					return false;

				});
			});
			SortedList<NhanVienDemo> sortedData = new SortedList<>(filterData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);

		});
		;

		// delete
		delete.setOnAction(event -> {
			ObservableList<NhanVienDemo> allStrings;
			ObservableList<NhanVienDemo> stringSelected;
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

			data.add(new NhanVienDemo(Integer.valueOf(txMaNv.getText()), txMaSp.getText(), txTen.getText(),
					dateOfBirth.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), txGetGender.getText(),
					txPhone.getText(), txdiachi.getText(), txViTri.getText()));

		});

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getStylesheets().add("stylesheets.css");
		this.getChildren().addAll(grid, table);

	}

}
