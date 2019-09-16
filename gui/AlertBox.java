package gui;

import alertbox.AlertBoxExtra;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Alert box class
 * sends pop up messages to user
 * @author fionn
 *
 */
public class AlertBox extends AlertBoxExtra {

	/**
	 * Displays message after user action
	 * @param title
	 * @param message
	 */
	public static void display(String title, String message) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);// block interaction with other windows until current window is closed
		window.setTitle(title);
		window.setHeight(250);
		window.setWidth(400);

		Label label = new Label(message);
		label.setAlignment(Pos.CENTER);
		Button close = new Button("Close window");
		close.setOnAction(e -> window.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, close);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
