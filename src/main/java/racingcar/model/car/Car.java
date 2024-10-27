package racingcar.model.car;

public class Car {

    private final String name;
    private int progress = 0;

    public Car(String name) {

        this.name = name;
    }

    public int getProgress() {

        return progress;
    }

    public String getName() {

        return name;
    }

    public void updateProgress() {

        progress++;
    }
}
