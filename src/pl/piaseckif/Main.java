package pl.piaseckif;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.piaseckif.model.Exercise;
import pl.piaseckif.model.ExerciseBuilder;
import pl.piaseckif.model.ExerciseName;
import pl.piaseckif.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Workout Tracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

        System.out.println(ExerciseName.DUMBBELL_BICEP_CURL);
        Exercise exercise = new ExerciseBuilder().setName(ExerciseName.BENCH_PRESS).setSets(5).setReps(5).setWeight(120).setDuration(null).build();
        System.out.println(exercise);
        List<Workout> workouts = new ArrayList<>();

        launch(args);
    }
}
