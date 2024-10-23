package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int status;

    public RacingCar(String name) {
        this.name = name;
    }

    public void moveOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            move();
        }
    }

    public void move() {
        status++;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusToDash() {
        return "-".repeat(Math.max(0, status));
    }
}
