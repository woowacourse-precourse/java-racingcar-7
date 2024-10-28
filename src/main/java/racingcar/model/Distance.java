package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Distance {

    private static final int RANDOM_EXPECTED = 4;

    private int position;

    public Distance() {
        position = 0;
    }

    public void moveOrNot() {
        int randomNumber = generateRandomNumber();
        updatePosition(randomNumber);
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void updatePosition(int randomNumber) {
        if (randomNumber >= RANDOM_EXPECTED) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
