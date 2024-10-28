package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {

    private static int RANDOM_RANGE_START = 0;
    private final int randomRangeEnd;
    private final int accelerationThreshold;
    private final int moveDistance;

    public RandomEngine(int moveDistance, int randomRangeEnd, int accelerationThreshold) {
        this.moveDistance = moveDistance;
        this.randomRangeEnd = randomRangeEnd;
        this.accelerationThreshold = accelerationThreshold;
    }

    @Override
    public int accelerate() {
        int number = Randoms.pickNumberInRange(RANDOM_RANGE_START, randomRangeEnd);
        if (number >= accelerationThreshold) {
            return moveDistance;
        }
        return 0;
    }
}
