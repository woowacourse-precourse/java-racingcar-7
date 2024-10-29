package racingcar.model;

public class Car {
    private final String name;
    private int progress;

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
