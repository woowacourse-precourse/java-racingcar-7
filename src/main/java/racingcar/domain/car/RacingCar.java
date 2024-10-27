package racingcar.domain.car;

import racingcar.domain.error.car.RacingCarErrorMessage;

public class RacingCar {

    private String name;
    private int forwardCount;

    public RacingCar(String name) {
        if (name.length() > RacingCarConstant.RacingCar_MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(RacingCarErrorMessage.OVER_NAME_LENGTH);
        }
        this.name = name;
        this.forwardCount = 0;
    }

    public void moveForward(int score) {
        if (score >= 4) {
            this.forwardCount++;
        }
    }

    public String getCurrentResultMessage() {
        String distance = "";
        for (int i = 0; i < forwardCount; i++) {
            distance += "-";
        }
        return this.name + " : " + distance;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
