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

public class Dam extends VBox{
	
	public Dam(Stage stage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageDam = new Image(
				getClass().getResourceAsStream("/Dam.jpg"));
				ImageView imageViewDam = new ImageView();
				imageViewDam.setFitHeight(400);
				imageViewDam.setFitWidth(400);
				imageViewDam.setImage(imageDam);
				grid.add(imageViewDam, 0, 0);

				Label lMaSp1 = new Label("Ma SP: D");
				grid.add(lMaSp1, 0, 1);

				Label lTen1 = new Label("Ten SP: Dam");
				grid.add(lTen1, 0, 2);

				Label lMaCt1 = new Label("Ma Cty: BE(Bento)");
				grid.add(lMaCt1, 0, 3);

				Label lGia1 = new Label("Gia: 250000");
				grid.add(lGia1, 0, 4);

				Label lTinhTrang1 = new Label("Tinh Trang SP: Gan ve");
				grid.add(lTinhTrang1, 0, 5);

				Label lNhanXet1 = new Label("Nhan Xet: Dep");
				grid.add(lNhanXet1, 0, 6);

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
