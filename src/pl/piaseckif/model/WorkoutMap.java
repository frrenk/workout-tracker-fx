package pl.piaseckif.model;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WorkoutMap {
    private static WorkoutMap ourInstance = new WorkoutMap();
    private Map<LocalDate, Workout> workouts = new HashMap<>();

    public static synchronized WorkoutMap getInstance() {
        return ourInstance;
    }

    private WorkoutMap() {
        loadWorkouts();
    }

    public void saveWorkouts() {
        System.out.println("savin startin");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.home")+"\\workoutTracker\\workouts.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workouts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(workouts);
    }

    public void loadWorkouts() {
        System.out.println("Habenin");
        try {
            FileInputStream loadWorkout = new FileInputStream(System.getProperty("user.home")+"\\workoutTracker\\workouts.dat");
            ObjectInputStream inputStream = new ObjectInputStream(loadWorkout);
            workouts = (Map<LocalDate, Workout>)inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<LocalDate, Workout> getWorkouts() {
        System.out.println("oer here");
        System.out.println(workouts);
        return workouts;
    }

    public void addWorkout(Workout workout) {
        workouts.put(workout.getDate(), workout);
    }
}
