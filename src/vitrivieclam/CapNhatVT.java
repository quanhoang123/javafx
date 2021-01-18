package vitrivieclam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CapNhatVT extends Stage {

	public CapNhatVT(VitrivieclamDemo vitri) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.getStyleClass().add("grid");
		
		Label mavt = new Label("Ma Vi Tri");
		grid.add(mavt, 0, 1);
		mavt.getStyleClass().add("label");
		
		TextField txmavt = new TextField(vitri.getMaViTri());
		grid.add(txmavt, 1, 1);
		
		Label vitrilv = new Label("Vi Tri Lam Viec");
		grid.add(vitrilv, 0,2 );
		vitrilv.getStyleClass().add("label");
		
		TextField txvitri = new TextField(vitri.getViTriLV());
		grid.add(txvitri, 1, 2);
		
		Label luong = new Label("Luong");
		grid.add(luong, 0, 3);
		luong.getStyleClass().add("label");
		

		TextField txluong = new TextField(vitri.getLuong().toString());
		grid.add(txluong, 1, 3);
		
		 Button update = new Button("Update");
			
			Button clear = new Button("Clear");
			
			HBox hbox = new HBox();
			hbox.setSpacing(25);
			hbox.getChildren().addAll(update, clear);
			grid.add(hbox, 1, 9);
			
			Scene scene = new Scene(grid);
			scene.getStylesheets().add("stylesheets.css");
			
			this.setTitle("Cap Nhat Vi Tri Lam Viec");
			this.setScene(scene);
	}
	

}
