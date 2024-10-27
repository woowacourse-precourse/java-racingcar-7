package util.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MINIMUM_MOVEMENT_VALUE = 4;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public int getRandomNumber() {
        int randomnumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomnumber;
    }

    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomNumber >= MINIMUM_MOVEMENT_VALUE;
    }
}