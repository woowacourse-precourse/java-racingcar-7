package racingcar.domain;

import racingcar.enums.WinnerStatus;

public class Car {

    private final String carName;
    private int presentLocation;
    private WinnerStatus winnerStatus;

    public Car(String carName) {
        this.carName = carName;
        this.presentLocation = 0;
        this.winnerStatus = WinnerStatus.NONE;
    }

    private void goForward() {
        this.presentLocation += 1;
    }

    public void winGame() {
        this.winnerStatus = WinnerStatus.WIN;
    }

    public int getPresentLocation() {
        return this.presentLocation;
    }

    public String getCarName() {
        return this.carName;
    }

    public WinnerStatus getWinnerStatus() {
        return this.winnerStatus;
    }

}
