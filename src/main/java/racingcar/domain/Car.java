package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int STANDARD = 4;

    private String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
    }

    public RacingHistory move() {
        if (Randoms.pickNumberInRange(0, 9) >= STANDARD) {
            totalDistance++;
        }
        return new RacingHistory(name, totalDistance);
    }
}
