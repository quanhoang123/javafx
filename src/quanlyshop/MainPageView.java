package quanlyshop;

import java.util.Stack;

import Login.Phieu_DangNhap;
import congtydoitac.CongTyManagerView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import quanlykhachhang.KhachHangView;
import quanlynhanvien.NhanVienManagementView;
import quanlynhanvien.NhanVienManager;
import quanlynhanvien.NhanVienManagerImpl;
import quanlysanpham.SanphamManagerView;
import vitrivieclam.VitrilamviecManagerView;

public class MainPageView extends VBox {

	private NhanVienManager employeeManager = new NhanVienManagerImpl();
	
	public static Stack<Stage> stages = new Stack<>();
	
	
	public  MainPageView(Stage primaryStage) throws Exception {

		MenuBar menuBar = createMenuBar();
		
		Stage stage = new Phieu_DangNhap();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		stage.showAndWait();

		if (Phieu_DangNhap.stateLogin) {
			primaryStage.show();
		}
		
		VBox vbox = new NhanVienManagementView(primaryStage);

		ListView<String> list = new ListView<>();
		list.setPrefWidth(200);
		ObservableList<String> items = FXCollections.observableArrayList("Quan Ly Nhan Vien", "Quan Ly Khach Hang", "Quan Ly San Pham","Vi Tri Viec Lam", "Cac Doi Tac");
		list.setItems(items);
		list.getStyleClass().add("menu");
		
		

		BorderPane border = new BorderPane();
		border.setTop(menuBar);
		border.setCenter(vbox);
		border.setLeft(list);
		border.setPadding(new Insets(0, 0, 10, 0));
		border.getStyleClass().add("menu");
		
		VBox vbox1 = new KhachHangView(primaryStage);
		VBox vbox2 = new SanphamManagerView(primaryStage);
		VBox vbox3 = new VitrilamviecManagerView(primaryStage);
		VBox vbox4 = new CongTyManagerView(primaryStage);
		
		list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				System.out.println("value: " + newValue);
				if ("0".equals(newValue.toString())) {
					border.setCenter(vbox);
					vbox.setVisible(true);
					System.out.println("visable");
				} 
				if ("1".equals(newValue.toString())) {
					border.setCenter(vbox1);
					vbox1.setVisible(true);
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
			}
			
		});
		
		

		
		Scene scene = new Scene(border);
		scene.getStylesheets().add("stylesheets.css");

		primaryStage.setTitle("             Quan Ly Shop Thoi Trang Friendly         ");
		primaryStage.setScene(scene);

		

	}

//	public static void main(String[] args) {
//		launch(args);
//	}
    


	private MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();

		Menu menuFile = new Menu("File");

		Image imgShuffle = new Image(getClass().getResourceAsStream("/register.png"));

		MenuItem add = new MenuItem("Shuffle", new ImageView(imgShuffle));
		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Shuffle");
			}

		});

		MenuItem clear = new MenuItem("Clear");
		clear.setAccelerator(KeyCombination.keyCombination("Ctrl + X"));

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}

		});

		menuFile.getItems().addAll(add, clear, new SeparatorMenuItem(), exit);

		Menu menuEdit = new Menu("Edit");

		Menu menuEffect = new Menu("Picture Effects");

		MenuItem noEffect = new MenuItem("No Effect");

		menuEdit.getItems().addAll(menuEffect, noEffect);

		ToggleGroup toggleGroup = new ToggleGroup();

		RadioMenuItem sepiaTone = new RadioMenuItem("Sepia Tone");
		sepiaTone.setToggleGroup(toggleGroup);

		RadioMenuItem grow = new RadioMenuItem("Grow");
		grow.setToggleGroup(toggleGroup);

		RadioMenuItem shadow = new RadioMenuItem("Shadow");
		shadow.setToggleGroup(toggleGroup);

		menuEffect.getItems().addAll(sepiaTone, grow, shadow);

		Menu menuView = new Menu("View");

		CheckMenuItem titleView = new CheckMenuItem("Title");
		titleView.setSelected(true);
		titleView.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				System.out.println("value: " + newValue.booleanValue());
			}

		});

		CheckMenuItem binNameView = new CheckMenuItem("Binomial Name");
		CheckMenuItem picView = new CheckMenuItem("Picture");
		CheckMenuItem descriptionView = new CheckMenuItem("Description");

		menuView.getItems().addAll(titleView, binNameView, picView, descriptionView);

		menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

		final ContextMenu cm = new ContextMenu();
		MenuItem cmItem1 = new MenuItem("Copy Image");

		cm.getItems().add(cmItem1);
		
		return menuBar;
	}
    
}
