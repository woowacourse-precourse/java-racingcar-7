package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    private final String name;
    private int distance = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void move() {
        if (isMovable()) {
            this.distance++;
        }
    }

    private void validateName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM) >= FORWARD_THRESHOLD;
    }
}
