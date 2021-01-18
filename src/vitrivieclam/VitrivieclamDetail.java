package vitrivieclam;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VitrivieclamDetail extends Stage{

	public VitrivieclamDetail(VitrivieclamDemo vitri) {
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));
		
		Label title = new Label("Vi Tri Lam Viec");
		GridPane.setConstraints(title, 0, 0, 2, 1,HPos.CENTER,VPos.BOTTOM);
		
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
		
		Scene scene = new Scene(grid);

		this.setTitle("Bang Vi Tri Lam Viec");
		this.setScene(scene);
		
	}
	

}
