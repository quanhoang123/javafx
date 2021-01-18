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

public class QuanJean extends VBox {

	public QuanJean(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");

		Image imageQuanJean = new Image(getClass().getResourceAsStream("/QuanJean.jpg"));
		ImageView imageViewQuanJean = new ImageView();
		imageViewQuanJean.setFitHeight(400);
		imageViewQuanJean.setFitWidth(400);
		imageViewQuanJean.setImage(imageQuanJean);
		grid.add(imageViewQuanJean, 0, 0);

		Label lMaSp5 = new Label("Ma SP: QJ");
		grid.add(lMaSp5, 0, 1);

		Label lTen5 = new Label("Ten SP: Quan Jeans");
		grid.add(lTen5, 0, 2);

		Label lMaCt5 = new Label("Ma Cty: TN(Tino)");
		grid.add(lMaCt5, 0, 3);

		Label lGia5 = new Label("Gia: 180000");
		grid.add(lGia5, 0, 4);

		Label lTinhTrang5 = new Label("Tinh Trang SP: Con nhieu");
		grid.add(lTinhTrang5, 0, 5);

		Label lNhanXet5 = new Label("Nhan Xet: Co gian tot");
		grid.add(lNhanXet5, 0, 6);

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
