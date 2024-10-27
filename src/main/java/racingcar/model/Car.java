package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private Status status;
    private int distance;
    private static final int MIN_SPEED = 4;

    private Car(String name) {
        this.name = name;
        this.status = Status.STOP;
        this.distance = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void generateSpeed() {
        int speed = Randoms.pickNumberInRange(0, 9);
        if (speed >= MIN_SPEED) {
            this.status = Status.MOVE;
        } else {
            this.status = Status.STOP;
        }
    }

    public boolean isMoveable() {
        return status == Status.MOVE;
    }

    public void move() {
        distance++;
    }
}
