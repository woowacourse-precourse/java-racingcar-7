package racingcar.model;

public record Car(String name, int distance) {

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
