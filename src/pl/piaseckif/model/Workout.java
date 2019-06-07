package pl.piaseckif.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Workout implements Serializable {

    private List<Exercise> exerciseList;
    private LocalDate date;

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
