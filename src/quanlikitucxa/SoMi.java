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

public class SoMi extends VBox {

	public SoMi(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");

		Image imageSoMi = new Image(getClass().getResourceAsStream("/SoMi.jpg"));
		ImageView imageViewSoMi = new ImageView();
		imageViewSoMi.setFitHeight(400);
		imageViewSoMi.setFitWidth(400);
		imageViewSoMi.setImage(imageSoMi);
		grid.add(imageViewSoMi, 0, 0);

		Label lMaSp8 = new Label("Ma SP: SM");
		grid.add(lMaSp8, 0, 1);

		Label lTen8 = new Label("Ten SP: Ao So Mi");
		grid.add(lTen8, 0, 2);

		Label lMaCt8 = new Label("Ma Cty: SA(Sanato)");
		grid.add(lMaCt8, 0, 3);

		Label lGia8 = new Label("Gia: 120000");
		grid.add(lGia8, 0, 4);

		Label lTinhTrang8 = new Label("Tinh Trang SP: Con nhieu");
		grid.add(lTinhTrang8, 0, 5);

		Label lNhanXet8 = new Label("Nhan Xet: Vai day");
		grid.add(lNhanXet8, 0, 6);

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
