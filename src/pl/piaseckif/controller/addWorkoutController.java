package pl.piaseckif.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.piaseckif.model.Exercise;
import pl.piaseckif.model.ExerciseName;
import pl.piaseckif.model.Workout;
import pl.piaseckif.model.WorkoutMap;

import javax.xml.soap.Text;
import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class addWorkoutController implements Initializable {



    @FXML private DatePicker newWorkoutDatePicker;
    @FXML private Button prevDayButton;
    @FXML private Button nextDayButton;

    @FXML private ChoiceBox<ExerciseName> ex1ChoiceBox;
    @FXML private TextField ex1SetsField;
    @FXML private TextField ex1repsField;
    @FXML private TextField ex1weightField;
    @FXML private TextField ex1durationField;

    @FXML private ChoiceBox<ExerciseName> ex2ChoiceBox;
    @FXML private TextField ex2SetsField;
    @FXML private TextField ex2repsField;
    @FXML private TextField ex2weightField;
    @FXML private TextField ex2durationField;

    @FXML private ChoiceBox<ExerciseName> ex3ChoiceBox;
    @FXML private TextField ex3SetsField;
    @FXML private TextField ex3repsField;
    @FXML private TextField ex3weightField;
    @FXML private TextField ex3durationField;

    @FXML private ChoiceBox<ExerciseName> ex4ChoiceBox;
    @FXML private TextField ex4SetsField;
    @FXML private TextField ex4repsField;
    @FXML private TextField ex4weightField;
    @FXML private TextField ex4durationField;

    @FXML private ChoiceBox<ExerciseName> ex5ChoiceBox;
    @FXML private TextField ex5SetsField;
    @FXML private TextField ex5repsField;
    @FXML private TextField ex5weightField;
    @FXML private TextField ex5durationField;

    @FXML private ChoiceBox<ExerciseName> ex6ChoiceBox;
    @FXML private TextField ex6SetsField;
    @FXML private TextField ex6repsField;
    @FXML private TextField ex6weightField;
    @FXML private TextField ex6durationField;

    @FXML private ChoiceBox<ExerciseName> ex7ChoiceBox;
    @FXML private TextField ex7SetsField;
    @FXML private TextField ex7repsField;
    @FXML private TextField ex7weightField;
    @FXML private TextField ex7durationField;

    @FXML private ChoiceBox<ExerciseName> ex8ChoiceBox;
    @FXML private TextField ex8SetsField;
    @FXML private TextField ex8repsField;
    @FXML private TextField ex8weightField;
    @FXML private TextField ex8durationField;

    @FXML private ChoiceBox<ExerciseName> ex9ChoiceBox;
    @FXML private TextField ex9SetsField;
    @FXML private TextField ex9repsField;
    @FXML private TextField ex9weightField;
    @FXML private TextField ex9durationField;

    @FXML private ChoiceBox<ExerciseName> ex10ChoiceBox;
    @FXML private TextField ex10SetsField;
    @FXML private TextField ex10repsField;
    @FXML private TextField ex10weightField;
    @FXML private TextField ex10durationField;

    @FXML private Button saveWorkoutButton;
    @FXML private Button cancelButton;

    private Workout workout = new Workout();

    private Map<LocalDate, Workout> workouts;

    
    private List<ChoiceBox> boxes = new ArrayList<>();

    private List<TextField> fields1 = new ArrayList<>();
    private List<TextField> fields2 = new ArrayList<>();
    private List<TextField> fields3 = new ArrayList<>();
    private List<TextField> fields4 = new ArrayList<>();
    private List<TextField> fields5 = new ArrayList<>();
    private List<TextField> fields6 = new ArrayList<>();
    private List<TextField> fields7 = new ArrayList<>();
    private List<TextField> fields8 = new ArrayList<>();
    private List<TextField> fields9 = new ArrayList<>();
    private List<TextField> fields10 = new ArrayList<>();

    private List<List<TextField>> allFields = new ArrayList<>();





    public void prevDay(ActionEvent actionEvent) {
        newWorkoutDatePicker.setValue(newWorkoutDatePicker.getValue().minusDays(1));
    }

    public void nextDay(ActionEvent actionEvent) {
        newWorkoutDatePicker.setValue(newWorkoutDatePicker.getValue().plusDays(1));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        workouts = WorkoutMap.getInstance().getWorkouts();
        WorkoutMap.getInstance().loadWorkouts();
        newWorkoutDatePicker.setValue(LocalDate.now());

        boxes.add(ex1ChoiceBox);
        boxes.add(ex2ChoiceBox);
        boxes.add(ex3ChoiceBox);
        boxes.add(ex4ChoiceBox);
        boxes.add(ex5ChoiceBox);
        boxes.add(ex6ChoiceBox);
        boxes.add(ex7ChoiceBox);
        boxes.add(ex8ChoiceBox);
        boxes.add(ex9ChoiceBox);
        boxes.add(ex10ChoiceBox);

        fields1.add(ex1SetsField);
        fields1.add(ex1repsField);
        fields1.add(ex1weightField);
        fields1.add(ex1durationField);

        fields2.add(ex2SetsField);
        fields2.add(ex2repsField);
        fields2.add(ex2weightField);
        fields2.add(ex2durationField);

        fields3.add(ex3SetsField);
        fields3.add(ex3repsField);
        fields3.add(ex3weightField);
        fields3.add(ex3durationField);

        fields4.add(ex4SetsField);
        fields4.add(ex4repsField);
        fields4.add(ex4weightField);
        fields4.add(ex4durationField);

        fields5.add(ex5SetsField);
        fields5.add(ex5repsField);
        fields5.add(ex5weightField);
        fields5.add(ex5durationField);

        fields6.add(ex6SetsField);
        fields6.add(ex6repsField);
        fields6.add(ex6weightField);
        fields6.add(ex6durationField);

        fields7.add(ex7SetsField);
        fields7.add(ex7repsField);
        fields7.add(ex7weightField);
        fields7.add(ex7durationField);

        fields8.add(ex8SetsField);
        fields8.add(ex8repsField);
        fields8.add(ex8weightField);
        fields8.add(ex8durationField);

        fields9.add(ex9SetsField);
        fields9.add(ex9repsField);
        fields9.add(ex9weightField);
        fields9.add(ex9durationField);

        fields10.add(ex10SetsField);
        fields10.add(ex10repsField);
        fields10.add(ex10weightField);
        fields10.add(ex10durationField);

        allFields.add(fields1);
        allFields.add(fields2);
        allFields.add(fields3);
        allFields.add(fields4);
        allFields.add(fields5);
        allFields.add(fields6);
        allFields.add(fields7);
        allFields.add(fields8);
        allFields.add(fields9);
        allFields.add(fields10);

        for (List<TextField> list: allFields) {
            for (TextField field: list) {
                field.setText("0");
            }
        }


        for (ChoiceBox<ExerciseName> box :
                boxes) {
            box.setItems(FXCollections.observableArrayList(Arrays.asList(ExerciseName.values())));

        }
    }

    public void saveWorkout(ActionEvent actionEvent) {
        List<Exercise> exercises = new ArrayList<>();
        workout.setDate(newWorkoutDatePicker.getValue());
        workout.setExerciseList(exercises);

        for (int i = 0; i < 10; i++) {
            if (boxes.get(i).getValue()!=null) {
                Exercise exercise = new Exercise();
                exercise.setName((ExerciseName)boxes.get(i).getValue());
                if (!allFields.get(i).get(0).getCharacters().toString().isEmpty()) {
                    exercise.setSets(Integer.parseInt(allFields.get(i).get(0).getCharacters().toString()));
                }
                if (allFields.get(i).get(1).getCharacters()!=null || !allFields.get(i).get(1).getCharacters().toString().isEmpty()) {
                    exercise.setReps(Integer.parseInt(allFields.get(i).get(1).getCharacters().toString()));
                }
                if (allFields.get(i).get(2).getCharacters()!=null || !allFields.get(i).get(2).getCharacters().toString().isEmpty()) {
                    exercise.setWeight(Integer.parseInt(allFields.get(i).get(2).getCharacters().toString()));
                }
                exercise.setDuration(Duration.ofMinutes(75));
                exercises.add(exercise);
            }
        }
        if (workouts.containsKey(workout.getDate())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Replace Workout?");
            alert.setContentText("There is already a workout with this date. Do you want to replace it?");
            ButtonType yesButton = ButtonType.YES;
            ButtonType noButton = ButtonType.NO;
            ButtonType alertCancelButton = ButtonType.CANCEL;
            alert.getButtonTypes().setAll(yesButton, noButton, alertCancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type==ButtonType.YES) {
                    WorkoutMap.getInstance().addWorkout(workout);
                    WorkoutMap.getInstance().saveWorkouts();
                    Stage stage = (Stage)cancelButton.getScene().getWindow();
                    stage.close();
                } else if (type==ButtonType.NO) {
                    Stage stage = (Stage)cancelButton.getScene().getWindow();
                    stage.close();
                } else {
                }
            });
        } else {
            WorkoutMap.getInstance().addWorkout(workout);
            WorkoutMap.getInstance().saveWorkouts();
            Stage stage = (Stage)cancelButton.getScene().getWindow();
            stage.close();
        }


    }

    //loads workout map from workouts.dat
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


    //saves changes to workout map to workouts.dat
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

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();

    }
}
