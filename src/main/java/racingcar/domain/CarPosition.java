package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public void increasePosition() {
        if (RandomNumberGenerator.pickNumberInRange() >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
