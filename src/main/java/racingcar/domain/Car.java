package racingcar.domain;

public class Car {

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void advance() {
        this.position++;
    }

    public String carName() {
        return name;
    }

    public int currentPosition() {
        return position;
    }

}
