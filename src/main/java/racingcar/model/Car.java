package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        String nonEmptyName = validateEmptyName(name);
        validateNameLength(nonEmptyName);
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 문자열만 가능합니다.");
        }
    }

    public static String validateEmptyName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("빈 이름은 사용할 수 없습니다.");
        }
        return name.trim();
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
