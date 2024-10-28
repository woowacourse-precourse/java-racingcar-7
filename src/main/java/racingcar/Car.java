package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Integer location;
    private String name;

    public Car(String name) {
        location = 0;
        name = name.trim();
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Car() {
        location = 0;
        throw new IllegalArgumentException();
    }

    private void move() {
        location++;
    }

    public void randomMove() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            this.move();
        } else {
            // 정지
        }
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
