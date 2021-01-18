package quanlyshop;


	import Login.Phieu_DangKi;
	import Login.Phieu_DangNhap;
import quanlikitucxa.DanhSachSP;
import javafx.application.Application;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.input.MouseEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
	import javafx.stage.Stage;
import quanlykhachhang.Phieu_DangNhapKH;
	
	public class scene extends Application {
	
		
		Scene login;
		
	
		public void start(Stage stage) {
			// scene 1: login
			BorderPane bor = new BorderPane();
	
			HBox hbox = new HBox();
			hbox.setSpacing(400);
			hbox.setPadding(new Insets(20, 0, 20, 650));
			Label tx = new Label("Friendly Shop");
			tx.getStyleClass().add("label1");
	
			Button signup = new Button("Sign Up");
			signup.setPrefSize(150, 50);
			signup.getStyleClass().add("label3");
			// setOnAction
			signup.setOnMouseClicked(new EventHandler<MouseEvent>() {
	
				@Override
				public void handle(MouseEvent mo) {
			    new Phieu_DangKi(stage);
			    
				}	
				
			});
			
	
			hbox.getChildren().addAll(tx, signup);
			bor.setTop(hbox);
			HBox hbox2 = new HBox();
			hbox2.setSpacing(20);
			hbox2.setPadding(new Insets(0, 20, 20, 0));
	
			Button admin = new Button("Admin");
			admin.setPrefSize(150, 50);
			admin.getStyleClass().add("label3");
			
			
			admin.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mo) {
					try {
						new MainPageView(stage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
	
			Button user = new Button("User");
			user.setPrefSize(150, 50);
			user.getStyleClass().add("label3");
			user.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mo) {
					// TODO Auto-generated method stub
					new DanhSachSP(stage);
					
					
				}
			});
	
			hbox2.getChildren().addAll(admin, user);
			hbox2.setAlignment(Pos.BOTTOM_RIGHT);
	
			bor.setBottom(hbox2);
			
	
			// Scene s = new Scene(bor,1600,900);
			bor.getStyleClass().add("background");
			login = new Scene(bor, 1600, 900);
			login.getStylesheets().add("Stylesheets.css");
	
			stage.setScene(login);
			stage.show();
	
		}
	
		public static void main(String[] args) {
			launch(args);
		}
	

}
