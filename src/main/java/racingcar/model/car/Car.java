package racingcar.model.car;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        forwardCount = 0;
    }

    @Override
    public String toString() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            progress.append("-");
        }
        return name + " : " + progress;
    }
}
