package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    private final String driverName;
    private final StringBuffer forwardedNumberDisplay = new StringBuffer();
    private int forwardedNumber = 0;

    public RacingCar(String driverName) {
        this.driverName = driverName;
        this.forwardedNumberDisplay
                .append(driverName)
                .append(" : ");
    }

    public void playRace() {
        if (isStop()) {
            return;
        }
        moveForward();
    }

    public String getForwardedDisplay() {
        return this.forwardedNumberDisplay.toString();
    }
    public int getForwardedNumber() {
        return this.forwardedNumber;
    }
    public String getDriverName() {
        return this.driverName;
    }

    private boolean isStop() {
        return pickNumberInRange(0, 9) < 4;
    }

    private void moveForward() {
        forwardedNumber++;
        forwardedNumberDisplay.append('-');
    }
}
