package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    public Car(String name) {
        String trimName = name.trim();
        validateName(trimName);
        this.name = trimName;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
        }
    }

    public void move() {
        if (canMove()) {
            distance++;
        }
    }

    private static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car otherCar) {
        return distance - otherCar.distance;
    }
}
