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
        if (isGo()) {
            moveForward();
        }
        System.out.println(getForwardedDisplay());
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

    private boolean isGo() {
        return pickNumberInRange(0, 9) > 3;
    }

    private void moveForward() {
        forwardedNumber++;
        forwardedNumberDisplay.append('-');
    }
}
