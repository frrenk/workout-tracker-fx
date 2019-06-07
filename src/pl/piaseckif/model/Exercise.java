package pl.piaseckif.model;

import java.io.Serializable;
import java.time.Duration;

public class Exercise implements Serializable {

    public ExerciseName name;
    public int sets;
    public int reps;
    public int weight;
    public Duration duration;

    public ExerciseName getName() {
        return name;
    }

    public void setName(ExerciseName name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name=" + name +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", duration=" + duration +
                '}';
    }


}
