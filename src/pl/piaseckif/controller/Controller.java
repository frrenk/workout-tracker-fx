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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    private List<Exercise> exercises1 = new ArrayList<>();
    private List<Exercise> exercises2 = new ArrayList<>();

    private Workout workout1 = new Workout();
    private Workout workout2 = new Workout();

    private List<Workout> workouts = new ArrayList<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(123);
        workoutDatePicker.setValue(LocalDate.now());

        exercises1.add(new ExerciseBuilder().setName(ExerciseName.DEADLIFT).setSets(5).setReps(3).setWeight(180).build());
        exercises1.add(new ExerciseBuilder().setName(ExerciseName.DEADLIFT).setSets(5).setReps(3).setWeight(170).build());
        exercises1.add(new ExerciseBuilder().setName(ExerciseName.SQUAT).setSets(5).setReps(3).setWeight(150).build());
        exercises1.add(new ExerciseBuilder().setName(ExerciseName.BENCH_PRESS).setSets(5).setReps(8).setWeight(70).build());


        exercises2.add(new ExerciseBuilder().setName(ExerciseName.JOGGING).setDuration(Duration.of(60, ChronoUnit.MINUTES)).build());
        exercises2.add(new ExerciseBuilder().setName(ExerciseName.DUMBBELL_BICEP_CURL).setSets(4).setReps(12).setWeight(24).build());


        workout1.setExerciseList(exercises1);
        workout1.setDate(LocalDate.now());

        workout2.setExerciseList(exercises2);
        workout2.setDate(LocalDate.of(2019, 6, 5));


        workouts.add(workout1);
        workouts.add(workout2);

        try {
            FileOutputStream saveWorkout = new FileOutputStream("C:\\Users\\fkpi\\IdeaProjects\\workout-tracker-fx\\resources\\workouts.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(saveWorkout);
            objOut.writeObject(workouts);
            objOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        exerciseColumn.setCellValueFactory(new PropertyValueFactory<Exercise, ExerciseName>("name"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("sets"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("reps"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("weight"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Exercise, String>("duration"));

        //editable rows?

        checkWorkouts();

    }



    public void updateTable(ActionEvent actionEvent) {
        exerciseTable.getItems().clear();
        checkWorkouts();

    }

    private void checkWorkouts() {
        for (Workout workout:workouts) {
            if (workout.getDate().equals(workoutDatePicker.getValue())) {
                exerciseTable.getItems().addAll(workout.getExerciseList());
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
    }

    public void exerciseEditCommit(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }

    public void exerciseEditCancel(TableColumn.CellEditEvent<Exercise, ExerciseName> exerciseExerciseNameCellEditEvent) {
    }
}
