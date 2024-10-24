package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int status;

    public RacingCar(String name) {
        this.name = name;
    }

    public void run(int cycle) {
        for (int i = 0; i < cycle; i++) {
            attemptMove();
        }
    }

    public void attemptMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            status++;
        }
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
