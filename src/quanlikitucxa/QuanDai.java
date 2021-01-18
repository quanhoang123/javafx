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

public class QuanDai extends VBox{
	
	public QuanDai(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageQuanDai = new Image(getClass().getResourceAsStream("/QuanDai.jpg"));
		ImageView imageViewQuanDai = new ImageView();
		imageViewQuanDai.setFitHeight(400);
		imageViewQuanDai.setFitWidth(400);
		imageViewQuanDai.setImage(imageQuanDai);
		grid.add(imageViewQuanDai, 0, 0);

		Label lMaSp3 = new Label("Ma SP: QD");
		grid.add(lMaSp3, 0, 1);

		Label lTen3 = new Label("Ten SP: Quan dai");
		grid.add(lTen3, 0, 2);

		Label lMaCt3 = new Label("Ma Cty: TN(Tino)");
		grid.add(lMaCt3, 0, 3);

		Label lGia3 = new Label("Gia: 150000");
		grid.add(lGia3, 0, 4);

		Label lTinhTrang3 = new Label("Tinh Trang SP: Con it");
		grid.add(lTinhTrang3, 0, 5);

		Label lNhanXet3 = new Label("Nhan Xet: Vai dep");
		grid.add(lNhanXet3, 0, 6);

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
