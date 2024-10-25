package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5자 이하이어야 합니다.";

    private final String name;
    private long position = 0;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public long getPosition() {
        return position;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return getRandomNumber() >= 4;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public int compareTo(Car o) {
        return Long.compare(this.position, o.position);
    }
}
