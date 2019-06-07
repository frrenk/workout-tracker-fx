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

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Workout Tracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

//        Map<LocalDate, Workout> workouts = new HashMap<>();
//
//        Workout workout1 = new Workout();
//        Workout workout2 = new Workout();
//        Workout workout3 = new Workout();
//
//        List<Exercise> ex1 = new ArrayList<>();
//        List<Exercise> ex2 = new ArrayList<>();
//        List<Exercise> ex3 = new ArrayList<>();
//
//        Exercise exercise1 = new ExerciseBuilder().setName(ExerciseName.BENCH_PRESS).setSets(5).setReps(5).setWeight(90).build();
//        Exercise exercise2 = new ExerciseBuilder().setName(ExerciseName.DEADLIFT).setSets(3).setReps(3).setWeight(180).build();
//        Exercise exercise3 = new ExerciseBuilder().setName(ExerciseName.SQUAT).setSets(4).setReps(4).setWeight(150).build();
//        Exercise exercise4 = new ExerciseBuilder().setName(ExerciseName.DUMBBELL_BICEP_CURL).setSets(4).setReps(12).setWeight(24).build();
//        Exercise exercise5 = new ExerciseBuilder().setName(ExerciseName.JOGGING).setDuration(Duration.ofMinutes(90)).build();
//
//        ex1.add(exercise1);
//        ex1.add(exercise2);
//        ex1.add(exercise4);
//        ex1.add(exercise5);
//
//        ex2.add(exercise2);
//        ex2.add(exercise2);
//        ex2.add(exercise4);
//        ex2.add(exercise5);
//        ex2.add(exercise1);
//        ex2.add(exercise3);
//
//        ex3.add(exercise2);
//        ex3.add(exercise3);
//        ex3.add(exercise4);
//        ex3.add(exercise1);
//        ex3.add(exercise1);
//        ex3.add(exercise1);
//        ex3.add(exercise1);
//        ex3.add(exercise1);
//
//        workout1.setExerciseList(ex1);
//        workout1.setDate(LocalDate.now());
//
//        workout2.setExerciseList(ex2);
//        workout2.setDate(LocalDate.of(2019, 6, 6));
//
//        workout3.setExerciseList(ex3);
//        workout3.setDate(LocalDate.of(2019, 6, 5));
//
//        workouts.put(workout1.getDate(), workout1);
//        workouts.put(workout2.getDate(), workout2);
//        workouts.put(workout3.getDate(), workout3);
//
//
//
//        try {
//            new File(System.getProperty("user.home")+"\\workoutTracker").mkdir();
//            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.home")+"\\workoutTracker\\workouts.dat");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(workouts);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }





//        System.out.println(ExerciseName.DUMBBELL_BICEP_CURL);
//        Exercise exercise = new ExerciseBuilder().setName(ExerciseName.BENCH_PRESS).setSets(5).setReps(5).setWeight(120).setDuration(null).build();
//        System.out.println(exercise);

        launch(args);
    }
}
