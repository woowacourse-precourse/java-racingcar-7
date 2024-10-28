package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int LIMIT = 4;
    private static final int RANDOM_RANGE_MIN = 0;
    private static final int RANDOM_RANGE_MAX = 9;

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX) >= LIMIT) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 불가능합니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하로 작성해야합니다.");
        }
    }
}