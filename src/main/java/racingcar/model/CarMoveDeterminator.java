package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;


public class CarMoveDeterminator {
    
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public static boolean determine() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }
    
}
