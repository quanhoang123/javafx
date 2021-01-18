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

public class AoBun extends VBox{
	
	public AoBun(Stage stage) {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageAoBull = new Image(getClass().getResourceAsStream("/AoBull.jpg"));
		ImageView imageViewAoBull = new ImageView();
		imageViewAoBull.setFitHeight(400);
		imageViewAoBull.setFitWidth(400);
		imageViewAoBull.setImage(imageAoBull);
		grid.add(imageViewAoBull, 0, 0);
		Label lMaSp4 = new Label("MA SP: AB");
		grid.add(lMaSp4, 0, 1);
		Label lTen4 = new Label("Ten SP: Ao Bulls ");
		grid.add(lTen4, 0, 2);
		Label lMaCt4 = new Label("Ma Cty: BE(Bento)");
		grid.add(lMaCt4, 0, 3);
		Label lGia4 = new Label("Gia: 85000");
		grid.add(lGia4, 0, 4);
		Label lTinhTrang4 = new Label("Tinh Trang SP: Con it");
		grid.add(lTinhTrang4, 0, 5);
		Label lNhanXet4 = new Label("Nhan Xet: Mat");
		grid.add(lNhanXet4, 0, 6);
		
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
