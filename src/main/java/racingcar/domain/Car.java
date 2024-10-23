package racingcar.domain;

public class Car {

    private static final int MOVING_STANDARD_NUMBER = 4;

    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
    }

    public int move(int randomNumber) {
        if (randomNumber >= MOVING_STANDARD_NUMBER) {
            movedDistance++;
        }
        return movedDistance;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
