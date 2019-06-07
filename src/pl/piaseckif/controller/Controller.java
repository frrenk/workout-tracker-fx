package pl.piaseckif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pl.piaseckif.model.*;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

public class Controller implements Initializable{

    @FXML private DatePicker workoutDatePicker;
    @FXML private Button prevDayButton;
    @FXML private Button nextDayButton;

    @FXML private TableView<Exercise> exerciseTable;
    @FXML private TableColumn<Exercise, ExerciseName> exerciseColumn;
    @FXML private TableColumn<Exercise, Integer> setsColumn;
    @FXML private TableColumn<Exercise, Integer> repsColumn;
    @FXML private TableColumn<Exercise, Integer> weightColumn;
    @FXML private TableColumn<Exercise, String> durationColumn;


    private Map<LocalDate, Workout> workouts;

    private Workout currentWorkout;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        workouts = WorkoutMap.getInstance().getWorkouts();
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<>("sets"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<>("reps"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        workoutDatePicker.setValue(LocalDate.now());
        WorkoutMap.getInstance().loadWorkouts();
        checkWorkouts();

    }


//    //loads workout map from workouts.dat
//    private void loadWorkouts() {
//        try {
//            FileInputStream loadWorkout = new FileInputStream(System.getProperty("user.home")+"\\workoutTracker\\workouts.dat");
//            ObjectInputStream inputStream = new ObjectInputStream(loadWorkout);
//            workouts = (Map<LocalDate, Workout>)inputStream.readObject();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    //saves changes to workout map to workouts.dat
//    private void saveWorkouts() {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.home")+"\\workoutTracker\\workouts.dat");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(workouts);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //called when date is changed with date picker
    public void updateTable(ActionEvent actionEvent) {
        exerciseTable.getItems().clear();
        WorkoutMap.getInstance().loadWorkouts();
        checkWorkouts();

    }


    //checks if there is a workout corresponding to currently picked date and loads data into the table
    private void checkWorkouts() {
        System.out.println(workouts);
        if (workouts.containsKey(workoutDatePicker.getValue())) {
            exerciseTable.getItems().addAll(workouts.get(workoutDatePicker.getValue()).getExerciseList());
        }
    }

    public void prevDay(ActionEvent actionEvent) {
        workoutDatePicker.setValue(workoutDatePicker.getValue().minusDays(1));
        updateTable(actionEvent);
    }

    public void nextDay(ActionEvent actionEvent) {
        workoutDatePicker.setValue(workoutDatePicker.getValue().plusDays(1));
        updateTable(actionEvent);
    }


    public void exerciseEditStart(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
        exerciseExerciseNameCellEditEvent.getNewValue();
    }

    public void exerciseEditCommit(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }

    public void exerciseEditCancel(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }

    public void deleteWorkout(ActionEvent actionEvent) {
        workouts.remove(workoutDatePicker.getValue());
        updateTable(actionEvent);
        WorkoutMap.getInstance().saveWorkouts();

    }

    public void newWorkout(ActionEvent actionEvent) throws IOException {
        Stage newWorkoutStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pl/piaseckif/view/addWorkoutView.fxml"));
        newWorkoutStage.setScene(new Scene(root));
        newWorkoutStage.setTitle("New Workout");
        newWorkoutStage.show();
    }
}
