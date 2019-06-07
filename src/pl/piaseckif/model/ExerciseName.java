package pl.piaseckif.model;

public enum ExerciseName {
    BENCH_PRESS("Bench Press"), SQUAT("Squat"), DEADLIFT("Deadlift"), DUMBBELL_BICEP_CURL("Dumbbell bicep curls"), JOGGING("Jogging");

    private String name;

    ExerciseName(String name) {
        this.name=name;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
