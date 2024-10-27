package racingcar.domain;

public class Car {
    private String name;
    private int racingCount;

    public Car(String name, int racingCount) {
        this.name = name;
        this.racingCount = racingCount;
    }

    public void addCount() {
        racingCount++;
    }
}
