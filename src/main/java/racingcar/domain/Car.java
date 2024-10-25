package racingcar.domain;

public class Car {

    private String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }
}
