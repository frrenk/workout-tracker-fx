package pl.piaseckif.model;

import java.time.Duration;

public class ExerciseBuilder {

    private Exercise exercise = new Exercise();


    public ExerciseBuilder setName(ExerciseName name) {
        this.exercise.setName(name);
        return this;
    }

    public ExerciseBuilder setSets(int num) {
        this.exercise.setSets(num);
        return this;
    }

    public ExerciseBuilder setReps(int num) {
        this.exercise.setReps(num);
        return this;
    }

    public ExerciseBuilder setWeight(int num) {
        this.exercise.setWeight(num);
        return this;
    }

    public ExerciseBuilder setDuration(Duration duration) {
        this.exercise.setDuration(duration);
        return this;
    }

    public Exercise build() {
        return exercise;
    }
}
