package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Integer location;
    private String name;

    public Car(String name) {
        location = 0;
        this.name = name;
    }

    public Car() {
        location = 0;
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
