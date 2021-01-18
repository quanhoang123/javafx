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

public class AoCoc extends VBox {
	public AoCoc(Stage stage) {	
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 15, 15, 15));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.getStyleClass().add("grid");
		
		Image imageAoCoc = new Image(getClass().getResourceAsStream("/AoCoc.jpg"));
		ImageView imageViewAoCoc = new ImageView();
		imageViewAoCoc.setFitHeight(400);
		imageViewAoCoc.setFitWidth(400);
		imageViewAoCoc.setImage(imageAoCoc);
		grid.add(imageViewAoCoc, 0, 0);
		Label lMaSp9 = new Label("Ma SP: AC");
		grid.add(lMaSp9, 0, 1);
		Label lTen9 = new Label("Ten SP: Ao Coc ");
		grid.add(lTen9, 0, 2);
		Label lMaCt9 = new Label("Ma Cty: MA(Macato)");
		grid.add(lMaCt9, 0, 3);
		Label lGia9 = new Label("Gia: 70000");
		grid.add(lGia9, 0, 4);
		Label lTinhTrang9 = new Label("Tinh Trang SP: Gan Het");
		grid.add(lTinhTrang9, 0, 5);
		Label lNhanXet9 = new Label("Nhan Xet: Mat");
		grid.add(lNhanXet9, 0, 6);
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
