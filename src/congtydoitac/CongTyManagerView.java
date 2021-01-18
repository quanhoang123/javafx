package congtydoitac;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vitrivieclam.VitrivieclamDemo;


public class CongTyManagerView extends VBox {
	
	private CongTyManager congty = new CongTyManagerImpl();

	public CongTyManagerView(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.getStyleClass().add("grid");
		
		Label title = new Label("Cac Doi Tac");
		GridPane.setConstraints(title, 2, 0, 4, 1, HPos.CENTER, VPos.CENTER);
		grid.add(title, 2, 0);
		title.getStyleClass().add("title");
		
		TableView<CongTyDemo> table = new TableView<>();
		table.setEditable(true);
		table.setPrefHeight(250);
	
	TableColumn<CongTyDemo, String> maCTCol = new TableColumn<>("Ma CongTy");
	maCTCol.setCellValueFactory(new PropertyValueFactory<>("MaCT"));
	maCTCol.setMinWidth(100);
	maCTCol.setCellFactory(TextFieldTableCell.forTableColumn());
	maCTCol.setOnEditCommit(new EventHandler<CellEditEvent<CongTyDemo, String>>() {
		@Override
		public void handle(CellEditEvent<CongTyDemo, String> t) {
			String newValue = t.getNewValue();
			int row = t.getTablePosition().getRow();
			t.getTableView().getItems().get(row).setMaCT(newValue);
		}

	});
	
	TableColumn<CongTyDemo, String> tenCol = new TableColumn<>("Ten Cong Ty");
	tenCol.setCellValueFactory(new PropertyValueFactory<>("Ten"));
	tenCol.setMinWidth(200);
	tenCol.setCellFactory(TextFieldTableCell.forTableColumn());
	tenCol.setOnEditCommit(new EventHandler<CellEditEvent<CongTyDemo, String>>() {
		@Override
		public void handle(CellEditEvent<CongTyDemo, String> t) {
			String newValue = t.getNewValue();
			int row = t.getTablePosition().getRow();
			t.getTableView().getItems().get(row).setTen(newValue);
		}

	});
	
	TableColumn<CongTyDemo, String> DiaChiCol = new TableColumn<>("Dia Chi");
	DiaChiCol.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
	DiaChiCol.setMinWidth(100);
	DiaChiCol.setCellFactory(TextFieldTableCell.forTableColumn());
	DiaChiCol.setOnEditCommit(new EventHandler<CellEditEvent<CongTyDemo, String>>() {
		@Override
		public void handle(CellEditEvent<CongTyDemo, String> t) {
			String newValue = t.getNewValue();
			int row = t.getTablePosition().getRow();
			t.getTableView().getItems().get(row).setDiaChi(newValue);
		}

	});
	
	TableColumn<CongTyDemo, String> sdtCol = new TableColumn<>("So Dien Thoai");
	sdtCol.setCellValueFactory(new PropertyValueFactory<>("SDT"));
	sdtCol.setMinWidth(100);
	sdtCol.setCellFactory(TextFieldTableCell.forTableColumn());
	sdtCol.setOnEditCommit(new EventHandler<CellEditEvent<CongTyDemo, String>>() {
		@Override
		public void handle(CellEditEvent<CongTyDemo, String> t) {
			String newValue = t.getNewValue();
			int row = t.getTablePosition().getRow();
			t.getTableView().getItems().get(row).setSDT(newValue);
		}

	});
	
	 table.getColumns().addAll( maCTCol, tenCol, DiaChiCol,sdtCol);
	 ObservableList<CongTyDemo> data = FXCollections.observableArrayList(congty.getAllCongTy());

		table.setItems(data);
		table.getStyleClass().add("table");
		
		final TextField addMaCT = new TextField();
		addMaCT.setPromptText("Ma Cong Ty");
		addMaCT.setMaxWidth(addMaCT.getPrefWidth());
        

        final TextField addtenCT = new TextField();
        addtenCT.setMaxWidth(addtenCT.getPrefWidth());
        addtenCT.setPromptText("Ten Cong Ty");

        final TextField addDiaChi = new TextField();
        addDiaChi.setMaxWidth(addDiaChi.getPrefWidth());
        addDiaChi.setPromptText("Dia Chi");
        
        final TextField addSDT = new TextField();
        addSDT.setMaxWidth(addSDT.getPrefWidth());
        addSDT.setPromptText("So Dien Thoai");
         
        final Button addButton = new Button("Add");
        addButton.getStyleClass().add("button");
		addButton.setOnAction((ActionEvent e) -> {

			data.add(new CongTyDemo(addMaCT.getText(), addtenCT.getText(), addDiaChi.getText(), addSDT.getText()));

		});
		
		Button delete= new Button("Delete");
		delete.getStyleClass().add("button");
		
		
		delete.setOnAction(event -> {
			ObservableList<CongTyDemo> allStrings;
			ObservableList<CongTyDemo> stringSelected;
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
        
        
        HBox hb = new HBox();
        hb.getChildren().addAll(addMaCT, addtenCT, addDiaChi,addSDT, addButton,delete);
        hb.setSpacing(3);
		
		 this.setPadding(new Insets(0, 20, 0, 20));
			this.getStylesheets().add("stylesheets.css");
			this.getChildren().addAll( grid,table,hb);
	}
	

}
