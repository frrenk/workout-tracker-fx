package pl.piaseckif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.piaseckif.model.Exercise;
import pl.piaseckif.model.ExerciseBuilder;
import pl.piaseckif.model.ExerciseName;
import pl.piaseckif.model.Workout;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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


    private List<Workout> workouts = new ArrayList<>();

    private Workout currentWorkout;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<>("sets"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<>("reps"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        workoutDatePicker.setValue(LocalDate.now());
        loadWorkouts();
        checkWorkouts();

    }

    private void loadWorkouts() {
        try {
            FileInputStream loadWorkout = new FileInputStream("C:\\Users\\fkpi\\IdeaProjects\\workout-tracker-fx\\resources\\workouts.dat");
            ObjectInputStream inputStream = new ObjectInputStream(loadWorkout);
            workouts = (List<Workout>)inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveWorkouts() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fkpi\\IdeaProjects\\workout-tracker-fx\\resources\\workouts.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workouts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateTable(ActionEvent actionEvent) {
        exerciseTable.getItems().clear();
        checkWorkouts();

    }

    private void checkWorkouts() {
        for (Workout workout:workouts) {
            if (workout.getDate().equals(workoutDatePicker.getValue())) {
                exerciseTable.getItems().addAll(workout.getExerciseList());
                currentWorkout = workout;
            }
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

    public void addWorkout(ActionEvent actionEvent) {
    }

    public void exerciseEditStart(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
        exerciseExerciseNameCellEditEvent.getNewValue();
    }

    public void exerciseEditCommit(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }

    public void exerciseEditCancel(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }

    public void deleteWorkout(ActionEvent actionEvent) {
        workouts.remove(currentWorkout);
        updateTable(actionEvent);
        saveWorkouts();

    }
}
