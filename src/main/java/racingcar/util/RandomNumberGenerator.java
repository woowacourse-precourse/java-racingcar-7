package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    public static final int RANDOM_MOVE_NUMBER = 4;

    /**
     * 랜덤숫자 추출
     * @return 랜덤 숫자
     */
    public static int move(){
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }
}
