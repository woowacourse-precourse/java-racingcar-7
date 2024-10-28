package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final String carName;
    private final int numberOfAttempts;

    public RacingGame(String carName, int numberOfAttempts) {
        this.carName = carName;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void startRace() {
        calculatePosition();
    }

    private void calculatePosition() {
        int position = 0;
        for(int i=0; i<this.numberOfAttempts; i++) {
            if(canMoveForward()) {
                position++;
            }
            System.out.println(this.carName + " : " + getDashesBasedOnPosition(position));
        }
        System.out.println();
    }

    private boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private String getDashesBasedOnPosition(int position) {
        return "-".repeat(position);
    }
}
