package Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Phieu_DangNhap  extends Stage{

	public static boolean stateLogin = false;
	IUserManagement user = new UserManagementImpl();
	
	public Phieu_DangNhap() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");

		Label userLogin = new Label(" Login");
		userLogin.setFont(new Font("Times New Roman", 23));
		GridPane.setConstraints(userLogin, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(userLogin, 0, 0, 2, 1);
		userLogin.getStyleClass().add("name");

		Label username = new Label("Ten dang nhap: ");
		grid.add(username, 0, 1);
		username.getStyleClass().add("label");

		TextField txUsername = new TextField();
		txUsername.setPrefWidth(200);
		grid.add(txUsername, 1, 1);

		Label password = new Label("Mat Khau: ");
		grid.add(password, 0, 2);
		password.getStyleClass().add("label");

		PasswordField pw = new PasswordField();
		pw.setPrefWidth(200);
		grid.add(pw, 1, 2);
		pw.setOnKeyPressed(new EventHandler<KeyEvent> () {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					if (user.checkLogin(txUsername.getText(), pw.getText())) {
					close();
						stateLogin = true;
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("ten dang nhap hoac mat khau sai !");
						alert.showAndWait();
					}
				}
			}
			
		});

		HBox hbox = new HBox();
		hbox.setSpacing(20);
		grid.add(hbox, 1, 3);
		
		Image imgLogin = new Image(getClass().getResourceAsStream("/login.png"));
		Image imgCancel = new Image(getClass().getResourceAsStream("/cancel.png"));

		Button login = new Button("Login");
		login.setGraphic(new ImageView(imgLogin));
		
		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (user.checkLogin(txUsername.getText(), pw.getText())) {
					close();
//					new MainPageView();
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("ten dang nhap hoac mat khau sai !");
					alert.showAndWait();
				}
			}

		});

		Button clear = new Button("Clear");
		clear.setGraphic(new ImageView(imgCancel));
		clear.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				txUsername.setText("");
				pw.setText("");
			}
		});

		hbox.getChildren().addAll(login, clear);

		Scene scene = new Scene(grid);
		
		Image iconStage = new Image(getClass().getResourceAsStream("/loginicon.png"));

		this.setTitle("Login");
		scene.getStylesheets().add("stylesheets.css");
		this.getIcons().add(iconStage);
		this.setScene(scene);
		
		
	}
}


