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

public class AoDai extends VBox{
	
	public AoDai(Stage stage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageAoDai = new Image(getClass().getResourceAsStream("/AoDai.jpg"));
		ImageView imageViewAoDai = new ImageView();
		imageViewAoDai.setFitHeight(400);
		imageViewAoDai.setFitWidth(400);
		imageViewAoDai.setImage(imageAoDai);
		grid.add(imageViewAoDai, 0, 0);
		
		Label lMaSp = new Label("Ma SP: AD");
		grid.add(lMaSp, 0, 1);

		Label lTen = new Label("Ten SP: Ao Dai");
		grid.add(lTen, 0, 2);

		Label lMaCt = new Label("Ma Cty: CH(Chicano)");
		grid.add(lMaCt, 0, 3);

		Label lGia = new Label("Gia: 550000");
		grid.add(lGia, 0, 4);

		Label lTinhTrang = new Label("Tinh Trang SP: Con nhieu");
		grid.add(lTinhTrang, 0, 5);

		Label lNhanXet = new Label("Nhan Xet: Dep");
		grid.add(lNhanXet, 0, 6);

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
