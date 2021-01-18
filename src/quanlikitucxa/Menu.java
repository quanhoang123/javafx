package quanlikitucxa;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu extends VBox{
	public Menu(Stage stage) {
		
		Label label = new Label("CHAO MUNG BAN DEN VOI FRIENDLY SHOP");
		label.setEffect(new DropShadow(20, Color.DARKGOLDENROD));
		label.getStyleClass().add("label3");
		this.getChildren().add(label);
		
		
		
		
	}

}
