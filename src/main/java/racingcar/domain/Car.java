package racingcar.domain;

public class Car {

    private String name;
    private int progress;

    Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }
}
