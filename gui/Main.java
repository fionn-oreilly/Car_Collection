package gui;

import car.CarList;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class manages GUI
 * @author fionn
 *
 */
public class Main extends Application {

	Stage window;
	CarList cars = new CarList();

	public static void main(String[] args) {
	    launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		StackPane SP = new StackPane();
		Label makeLabel = new Label("Make:");
		makeLabel.setPadding(new Insets(0, 20, 0, 10));
		Label modelLabel = new Label("Model:");
		modelLabel.setPadding(new Insets(0, 20, 0, 10));
		Label regLabel = new Label("Registration:");
		regLabel.setPadding(new Insets(0, 20, 0, 10));
		Label mileageLabel = new Label("Mileage:");
		mileageLabel.setPadding(new Insets(0, 20, 0, 10));
		Label manuLabel = new Label("Manufacture Year:");
		manuLabel.setPadding(new Insets(0, 20, 0, 10));

		TextField makeField = new TextField();
		makeField.setPromptText("Enter car make");
		makeField.setPadding(new Insets(0, 0, 5, 0));
		TextField modelField = new TextField();
		modelField.setPromptText("Enter car model");
		modelField.setPadding(new Insets(0, 0, 5, 0));
		TextField regField = new TextField();
		regField.setPromptText("Enter car registration number");
		regField.setPadding(new Insets(0, 0, 5, 0));
		regField.setPrefWidth(200);
		TextField mileageField = new TextField();
		mileageField.setPromptText("Enter mileage of car");
		mileageField.setPadding(new Insets(0, 0, 5, 0));
		TextField manuField = new TextField();
		manuField.setPromptText("Enter manufacture year of car");
		manuField.setPadding(new Insets(0, 0, 5, 0));
		manuField.setPrefWidth(200);


		TextArea TA = new TextArea();
		TA.setPrefSize(600, 200);

		Button add = new Button("Add");
		add.setPadding(new Insets(5, 5, 10, 10));
		add.setOnAction(e -> {
			try {
				String make = makeField.getText();
				String model = modelField.getText();
				int reg = Integer.parseInt(regField.getText());
				int mileage = Integer.parseInt(mileageField.getText());
				int manu_year = Integer.parseInt(manuField.getText());

				cars.addCar(make, model, reg, mileage, manu_year);
				AlertBox.display("Success","Car detailes have been added");
			} catch (Exception ex) {
				AlertBox.displayError("Error", "Please ensure all fields are filled correctly.\n"
						+ "Make and Model must be String.\nRegistration, Mileage and Manufacture Year must be Integer.");
			}
		});
		
		Button remove = new Button("Remove");
		remove.setPadding(new Insets(5, 5, 10, 10));
		remove.setOnAction(e -> {
			try {
				int reg = Integer.parseInt(regField.getText());
				boolean exists = cars.removeCar(reg);
				if (exists) {
					AlertBox.display("Success","Car with registration number\n\t\t\"" + reg + "\"\nhas been removed from list");
				} else {
					AlertBox.displayError("Error","Registration number does not exist.");
				}
			} catch (NumberFormatException ex) {
				AlertBox.displayError("Error","Registration field must be integer");
			} catch (Exception ex) {
				AlertBox.displayError("Error","Registration number does not exist.");
			}
		});

		Button listByMakeModel = new Button("List by Make & Model");
		listByMakeModel.setPadding(new Insets(5, 5, 10, 10));
		listByMakeModel.setOnAction(e -> {
			try {
				cars.print("MakeModel",TA);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		});

		Button listByYear = new Button("List by Year");
		listByYear.setPadding(new Insets(5, 5, 10, 10));
		listByYear.setOnAction(e -> {
			try {
				cars.print("Year",TA);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		});

		Button listByMileage = new Button("List by Mileage");
		listByMileage.setPadding(new Insets(5, 5, 10, 10));
		listByMileage.setOnAction(e -> {
			try {
				cars.print("Mileage", TA);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		});
		
		Button close = new Button("Close");
		close.setPadding(new Insets(5, 5, 10, 10));
		close.setOnAction(e -> System.exit(0));

		HBox row1 = new HBox();
		row1.getChildren().addAll(makeLabel,makeField,modelLabel,modelField,regLabel,regField);
		row1.setAlignment(Pos.TOP_CENTER);
		row1.setPadding(new Insets(10, 0, 0, 0));

		HBox row2 = new HBox();
		row2.getChildren().addAll(mileageLabel,mileageField,manuLabel,manuField);
		row2.setAlignment(Pos.TOP_CENTER);
		row2.setPadding(new Insets(10, 0, 0, 0));

		HBox buttons1 = new HBox();
		buttons1.getChildren().addAll(add,remove,close);
		buttons1.setAlignment(Pos.TOP_CENTER);
		buttons1.setPadding(new Insets(10, 0, 0, 0));

		HBox buttons2 = new HBox();
		buttons2.getChildren().addAll(listByMakeModel,listByYear,listByMileage);
		buttons2.setAlignment(Pos.TOP_CENTER);
		buttons2.setPadding(new Insets(10, 0, 0, 0));


		VBox stack = new VBox();
		stack.getChildren().addAll(row1,row2,buttons1,buttons2,TA);
		stack.setAlignment(Pos.TOP_CENTER);

		SP.getChildren().addAll(stack);
		Scene scene = new Scene(SP, 900,400);
		window.setTitle("Car Details");
		window.setScene(scene);
		window.show();
	}
}
