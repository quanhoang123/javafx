package quanlikitucxa;

import giaodienhoadon.HoaDon;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vay extends VBox {

	public Vay(Stage stage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");

		Image imageVay = new Image(getClass().getResourceAsStream("/Vay.jpg"));
		ImageView imageViewVay = new ImageView();
		imageViewVay.setFitHeight(400);
		imageViewVay.setFitWidth(400);
		imageViewVay.setImage(imageVay);
		grid.add(imageViewVay, 0, 0);

		Label lMaSp6 = new Label("Ma SP: V");
		grid.add(lMaSp6, 0, 1);

		Label lTen6 = new Label("Ten SP: Vay");
		grid.add(lTen6, 0, 2);

		Label lMaCt6 = new Label("Ma Cty: CH(Chicano)");
		grid.add(lMaCt6, 0, 3);

		Label lGia6 = new Label("Gia: 350000");
		grid.add(lGia6, 0, 4);

		Label lTinhTrang6 = new Label("TInh Trang SP: Het");
		grid.add(lTinhTrang6, 0, 5);

		Label lNhanXet6 = new Label("Nhan Xet: Tot");
		grid.add(lNhanXet6, 0, 6);

		Button button = new Button("Mua");
		button.getStyleClass().add("button");
		GridPane.setConstraints(button, 1, 3, 1, 1, HPos.RIGHT, VPos.BOTTOM);
		grid.add(button, 1, 3);
		
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new HoaDon(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});

	}
}
