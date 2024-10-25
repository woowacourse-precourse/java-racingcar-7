package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this.name = new CarName(name);
        position = Position.ZERO;
    }

    public Car(CarName name) {
        this.name = name;
        position = Position.ZERO;
    }

    public void move() {
        if (canMove()) {
            position = position.move();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public CarStatus getStatus() {
        return new CarStatus(name.name(), position.position());
    }

    public String getName() {
        return name.name();
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}
