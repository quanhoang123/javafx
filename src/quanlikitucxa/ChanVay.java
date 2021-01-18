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

public class ChanVay extends VBox{
	
	public ChanVay(Stage stage) {
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageChanVay = new Image(getClass().getResourceAsStream("/ChanVay.jpg"));
		ImageView imageViewChanVay = new ImageView();
		imageViewChanVay.setFitHeight(400);
		imageViewChanVay.setFitWidth(400);
		imageViewChanVay.setImage(imageChanVay);
		grid.add(imageViewChanVay, 0, 0);

		Label lMaSp7 = new Label("Ma SP: CV");
		grid.add(lMaSp7, 0, 1);

		Label lTen7 = new Label("Ten SP: Chan Vay ");
		grid.add(lTen7, 0, 2);

		Label lMaCt7 = new Label("Ma Cty: CH(Chicano)");
		grid.add(lMaCt7, 0, 3);

		Label lGia7 = new Label("Gia: 350000");
		grid.add(lGia7, 0, 4);

		Label lTinhTrang7 = new Label("Tinh Trang SP: Con it");
		grid.add(lTinhTrang7, 0, 5);

		Label lNhanXet7 = new Label("Nhan Xet: Vai dep");
		grid.add(lNhanXet7, 0, 6);

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
		
		
		this.getChildren().addAll(grid);

	}

}
