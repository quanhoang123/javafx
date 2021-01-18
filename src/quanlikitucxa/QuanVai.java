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

public class QuanVai extends VBox {

	public QuanVai(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageQuanVai = new Image(getClass().getResourceAsStream("/QuanVai.jpg"));
		ImageView imageViewQuanVai = new ImageView();
		imageViewQuanVai.setFitHeight(400);
		imageViewQuanVai.setFitWidth(400);
		imageViewQuanVai.setImage(imageQuanVai);
		grid.add(imageViewQuanVai, 0, 0);

		Label lMaSp2 = new Label("Ma SP: QV");
		grid.add(lMaSp2, 0, 1);

		Label lTen2 = new Label("Ten SP: Quan Vai");
		grid.add(lTen2, 0, 2);

		Label lMaCt2 = new Label("Ma Cty: MA(Macato)");
		grid.add(lMaCt2, 0, 3);

		Label lGia2 = new Label("Gia: 250000");
		grid.add(lGia2, 0, 4);

		Label lTinhTrang2 = new Label("Tinh Trang SP: Con it");
		grid.add(lTinhTrang2, 0, 5);

		Label lNhanXet2 = new Label("Nhan Xet: Tot");
		grid.add(lNhanXet2, 0, 6);

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
