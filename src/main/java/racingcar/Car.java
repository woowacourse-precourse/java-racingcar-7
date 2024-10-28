package racingcar;

public class Car {
    private final String name;
    private String progress = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public void move() {
        progress += "-";
    }
}
