package jac444.wk4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Namra Rupesh Fanse
 */
public class StudentApp extends Application {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage) Entry point if
	 * this application loads the FXML file
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLStudent.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Student Application");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Main launches the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
