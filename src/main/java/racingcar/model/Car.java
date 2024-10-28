package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance;

    public Car(String name, int distance) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name) {
        return new Car(name.trim(), 0);
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 문자열만 가능합니다.");
        }
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("빈 이름은 사용할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return this.name + " : " + "-".repeat(this.distance);
    }
}
