package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingcarRandomUtil implements RandomUtil{

    private static final int CAR_NUMBER_START_INCLUSIVE = 0;
    private static final int CAR_NUMBER_END_INCLUSIVE = 9;

    private static RacingcarRandomUtil instance;

    private RacingcarRandomUtil() {
    }

    public static RacingcarRandomUtil getInstance() {
        if (instance == null) {
            instance = new RacingcarRandomUtil();
        }
        return instance;
    }

    @Override
    public int pickCarNumber() {
        return Randoms.pickNumberInRange(CAR_NUMBER_START_INCLUSIVE, CAR_NUMBER_END_INCLUSIVE);
    }
}
