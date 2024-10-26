package racingcar.util;

public class Random implements NumberGenerator {
    private static final int MINIMUM_NUMBER_RANGE = 0;
    private static final int MAXIMUM_NUMBER_RANGE = 9;

    @Override
    public int pickNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(MINIMUM_NUMBER_RANGE, MAXIMUM_NUMBER_RANGE);
    }
}
