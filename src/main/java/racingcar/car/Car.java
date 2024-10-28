package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;   // 자동차의 이름 (변경 불가)
    private String distance = "";    // 이동 거리

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    // 자동차 전진 시도 메서드
    public void tryMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            distance += "-";
        }
    }
}