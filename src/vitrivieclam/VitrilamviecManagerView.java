package vitrivieclam;

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
import quanlysanpham.SanphamDemo;
import quanlysanpham.SanphamDetail;

public class VitrilamviecManagerView extends VBox {
	private VitrivieclamManager vitri = new VitrivieclamManagerImpl();

	public VitrilamviecManagerView(Stage stage) {

		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.getStyleClass().add("grid");

		Label mavt = new Label("Ma Vi Tri");
		grid.add(mavt, 0, 1);
		mavt.getStyleClass().add("label");

		TextField txmavt = new TextField();
		grid.add(txmavt, 1, 1);

		Label vitrilv = new Label("Vi Tri Lam Viec");
		grid.add(vitrilv, 0, 2);
		vitrilv.getStyleClass().add("label");

		TextField txvitri = new TextField();
		grid.add(txvitri, 1, 2);

		Label luong = new Label("Luong");
		grid.add(luong, 0, 3);
		luong.getStyleClass().add("label");

		TextField txluong = new TextField();
		grid.add(txluong, 1, 3);

		Label lbSearch = new Label("Type here to search ");
		grid.add(lbSearch, 1, 4);

		TextField txSearch = new TextField();
		grid.add(txSearch, 2, 4);

		TableView<VitrivieclamDemo> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);

		TableColumn<VitrivieclamDemo, String> maVt = new TableColumn<>("Ma Vi Tri Viec Lam");
		maVt.setCellValueFactory(new PropertyValueFactory<>("MaViTri"));
		maVt.setMinWidth(100);
		maVt.setCellFactory(TextFieldTableCell.forTableColumn());
		maVt.setOnEditCommit(new EventHandler<CellEditEvent<VitrivieclamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<VitrivieclamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setMaViTri(newValue);
			}

		});

		TableColumn<VitrivieclamDemo, String> tenCol = new TableColumn<>("Vi Tri Viec Lam");
		tenCol.setCellValueFactory(new PropertyValueFactory<>("ViTriLV"));
		tenCol.setMinWidth(200);
		tenCol.setCellFactory(TextFieldTableCell.forTableColumn());
		tenCol.setOnEditCommit(new EventHandler<CellEditEvent<VitrivieclamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<VitrivieclamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setViTriLV(newValue);
			}

		});

		TableColumn<VitrivieclamDemo, String> luongCol = new TableColumn<>("Luong");
		luongCol.setCellValueFactory(new PropertyValueFactory<>("Luong"));
		luongCol.setMinWidth(100);
		luongCol.setCellFactory(TextFieldTableCell.forTableColumn());
		luongCol.setOnEditCommit(new EventHandler<CellEditEvent<VitrivieclamDemo, String>>() {
			@Override
			public void handle(CellEditEvent<VitrivieclamDemo, String> t) {
				String newValue = t.getNewValue();
				int row = t.getTablePosition().getRow();
				t.getTableView().getItems().get(row).setViTriLV(newValue);
			}

		});

		table.getColumns().addAll(maVt, tenCol, luongCol);
		ObservableList<VitrivieclamDemo> data = FXCollections.observableArrayList(vitri.getAllBan());

		table.setItems(data);
		table.getStyleClass().add("table");

		// Image imgSearch = new Image(getClass().getResourceAsStream("/search.png"));
		Image imgAdd = new Image(getClass().getResourceAsStream("/add.png"));
		Image imgUpdate = new Image(getClass().getResourceAsStream("/update.png"));

//
//		Button search = new Button("Search");
//		search.setGraphic(new ImageView(imgSearch));
//		search.getStyleClass().add("button");

		Button insert = new Button("Insert");
		insert.setGraphic(new ImageView(imgAdd));
		insert.getStyleClass().add("button");

		Button detail = new Button("Detail");
		detail.setGraphic(new ImageView(imgUpdate));
		detail.getStyleClass().add("button");

		Button delete = new Button("Delete");
		delete.getStyleClass().add("button");

		HBox hbox = new HBox();
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10, 0, 10, 0));
		hbox.getChildren().addAll(insert, detail, delete);
		hbox.setAlignment(Pos.CENTER);
		grid.add(hbox, 0, 5, 4, 1);

		detail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				VitrivieclamDemo vl = table.getSelectionModel().getSelectedItem();
			
				if (vl == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Chi tiet Vi tri");
					alert.setContentText("Vui long chon du lieu trong bang");
					alert.showAndWait();
				} else {
					Stage vt = new VitrivieclamDetail(vl);

					vt.initModality(Modality.WINDOW_MODAL);
					vt.initOwner(stage);
					vt.showAndWait();
				}

			}
		});

		// funtion search

		FilteredList<VitrivieclamDemo> filterData = new FilteredList<>(data, e -> true);
		txSearch.setOnKeyReleased(e -> {
			txSearch.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
				filterData.setPredicate((Predicate<? super VitrivieclamDemo>) vitri -> {
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (vitri.getMaViTri().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (vitri.getViTriLV().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					} else if (vitri.getLuong().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}

					return false;

				});
			});
			SortedList<VitrivieclamDemo> sortedData = new SortedList<>(filterData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);

		});
		;

		// delete
		delete.setOnAction(event -> {
			ObservableList<VitrivieclamDemo> allStrings;
			ObservableList<VitrivieclamDemo> stringSelected;
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

			data.add(new VitrivieclamDemo(txmavt.getText(), txvitri.getText(), txluong.getText()));

		});

		this.setPadding(new Insets(0, 20, 0, 20));
		this.getStylesheets().add("stylesheets.css");
		this.getChildren().addAll(grid, table);

	}

}
