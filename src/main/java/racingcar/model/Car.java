package racingcar.model;

public record Car(String name, Integer distance) {

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
