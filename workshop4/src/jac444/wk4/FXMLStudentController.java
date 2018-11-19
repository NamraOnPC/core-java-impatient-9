package jac444.wk4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author Namra Rupesh Fanse
 */
public class FXMLStudentController implements Initializable {

	/**
	 * stores maximum grades ( made it a static final just in case it needs to be
	 * changed ).
	 */
	private static final int MAX_GRADES = 100;

	/**
	 * stores minimum grades ( made it a static final just in case it needs to be
	 * changed ).
	 */
	private static final int MIN_GRADES = 0;

	/**
	 * Buttons declarations used for manipulate functioning of buttons on the scene.
	 */
	@FXML
	private Button save, new2, load, delete, edit;

	/**
	 * A Label used for notifying user for application operations.
	 */
	@FXML
	private Label presenter;

	/**
	 * Font declaration just in case font needs to be changed.
	 */
	@FXML
	private Font x1;

	/**
	 * TextFields declarations used to manipulate functioning of buttons on the
	 * scene.
	 */
	@FXML
	private TextField fileName, name, course, grade;

	// ArrayList<TextField> fieldList = new ArrayList<TextField>();

	/**
	 * Enables Name , Course and Grade Fields to accept user input. Clears Name ,
	 * Course and Grade Fields to accept user input. Enables Save Button to save the
	 * user entered data.
	 * 
	 * @param event ( New Button is Clicked )
	 */
	@FXML
	private void newStudent(ActionEvent event) {

		name.setDisable(false);
		course.setDisable(false);
		grade.setDisable(false);

		name.clear();
		course.clear();
		grade.clear();

		save.setDisable(false);
	}

	/**
	 * Instantiates a new student object. sets Name and Course from the data entered
	 * in the TextFields. checks if the grade entered in the TextField is more than
	 * minimum grade and less then minimum grade. If its not shows an alert and asks
	 * the user to enter the valid data. If the input is valid tries to open file
	 * name mentioned in the TextField , tries to open file output stream and object
	 * output stream to stream object data to the file and save it.If operations are
	 * successful notifies user about the success of operation or else throws
	 * exceptions and notifies user about that. Enables Edit , Delete and New
	 * Buttons so that user can input data as required.
	 * 
	 * @param event ( Save Button is Clicked )
	 */
	@FXML
	private void saveTheStudent(ActionEvent event) {
		Student student = new Student();

		student.setName(name.getText());
		student.setCourse(course.getText());

		int grades = Integer.parseInt(grade.getText());

		if (grades < MAX_GRADES && grades > MIN_GRADES) {

			student.setGrade(Integer.parseInt(grade.getText()));

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");

			alert.setContentText("Please Enter Grades between " + MIN_GRADES + " and " + MAX_GRADES);
			alert.showAndWait();

		}

		if (fileName == null) {

			presenter.setText("Please enter filename");

		}

		try {

			if (grades < MAX_GRADES && grades > MIN_GRADES) {

				File file = new File(fileName.getText());
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(student);
				oos.close();
				fos.close();

				presenter.setText("Student Data successfully stored!");

			} else {
				presenter.setText("Error saving student data.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			presenter.setText("ERROR saving student data.");
		}

		edit.setDisable(false);
		delete.setDisable(false);
		new2.setDisable(false);
	}

	/**
	 * Registers clicked event. Clears the Name , Course and Grade TextFields so
	 * they can be filled with stored Data. Opens the file mentioned in the File
	 * TextField. Tries to open File Input Stream and Object Input Stream to receive
	 * object data from the file. Reads the student object stored in the file and
	 * assigns data to a local object accordingly. Prints the received data to the
	 * TextFields. Disables Name , Course and Grade TextFields to prevent invalid
	 * user input. Closes the file and object input streams. If above operations are
	 * successful notifies user with information. If above operations fail throws
	 * exception and notifies user with information.
	 * 
	 * @param event ( Load Button is Clicked )
	 */
	@FXML
	private void loadTheStudent(ActionEvent event) {

		name.clear();
		course.clear();
		grade.clear();

		File file = new File(fileName.getText());

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Student studentl = (Student) ois.readObject();

			name.appendText(studentl.getName());
			course.appendText(studentl.getCourse());
			grade.appendText(String.valueOf(studentl.getGrade()));

			name.setDisable(true);
			course.setDisable(true);
			grade.setDisable(true);

			presenter.setText("Student Data successfully loaded!");

			ois.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			presenter.setText("Error loading student data.");
		}

		delete.setDisable(false);
		edit.setDisable(false);

	}

	/**
	 * Registers click event. Disables New and Delete Button to prevent invalid user
	 * input. Enables Save Button to save the entered data. Enables Name , Course
	 * and Grade TextFields to enter data.
	 * 
	 * @param event ( Edit Button is Clicked )
	 */
	@FXML
	private void editTheStudent(ActionEvent event) {

		new2.setDisable(true);
		delete.setDisable(true);
		save.setDisable(false);

		name.setDisable(false);
		course.setDisable(false);
		grade.setDisable(false);

	}

	/**
	 * @param event ( Delete Button is Clicked )
	 * @throws IOException Creates two ButtonType instances for custom Delete
	 *                     Student and Cancel button( assigns tag for a cancel and
	 *                     close). Creates and Alert with Confirmation type to
	 *                     confirm if the user wants to delete the student data or
	 *                     not. Assigns ButtonType instances to the Alert. Fills an
	 *                     Optional container object with alert data and waits for
	 *                     the user input. if result is delete student opens the
	 *                     object stream to the file stream and removes the stored
	 *                     object from the file. Deletes the file mentioned in the
	 *                     File TextField from the disk. Notifies user about the
	 *                     operation. If the user cancels the delete operation
	 *                     notifies the user about the operation and loads the
	 *                     existing student data.
	 * 
	 */
	@FXML
	private void removeTheStudent(ActionEvent event) throws IOException {

		ButtonType deleteStudent = new ButtonType("Delete Student");
		ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Alert!");

		alert.setContentText("Are you sure you want to delete this Student Data ?");
		alert.getButtonTypes().setAll(deleteStudent, cancel);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == deleteStudent) {

			OutputStream os = null;

			try {

				try {
					os = new FileOutputStream(fileName.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				if (os != null) {
					os.close();
				}

			}

			File file = new File(fileName.getText());

			if (file.delete()) {

				presenter.setText("Student Data Deleted!");

			} else {
				presenter.setText("Error in deleting student data file");
			}
		} else {
			loadTheStudent(event);
			presenter.setText("Student Data deletion cancelled");
		}

	}

	/*
	 * Initializes the controller. Delete , Edit and Save Buttons are disabled to
	 * prevent invalid user input. Name , Course and Grade TextFields are disabled
	 * to prevent invalid user input. (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		delete.setDisable(true);
		edit.setDisable(true);
		save.setDisable(true);
		name.setDisable(true);
		course.setDisable(true);
		grade.setDisable(true);
	}
}
