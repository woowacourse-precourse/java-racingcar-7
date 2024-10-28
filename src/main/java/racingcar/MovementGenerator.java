package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int GO_THRESHOLD = 4;

    public static Movement getRandomMovement() {
        if (isNumberMoreThanFour(getRandomNumber())) {
            return Movement.GO;
        }
        return Movement.STOP;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private static boolean isNumberMoreThanFour(int number){
        return number >= GO_THRESHOLD;
    }
}
