package racingcar.domain;

public class Car {
    private static final int MINIMUM_ADVANCE_VALUE = 4;

    private final String name;
    private int distance;


    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    private void validateName(){}

    public void setDistance(int randomNumber) {
        if (randomNumber >= MINIMUM_ADVANCE_VALUE) {
            this.distance += 1;
        }
    }
}
