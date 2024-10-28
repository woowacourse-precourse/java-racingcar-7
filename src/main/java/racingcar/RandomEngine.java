package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {

    private static int RANDOM_RANGE_START = 0;
    private static int RANDOM_RANGE_END = 9;
    private static int ACCELERATION_THRESHOLD = 4;
    private int moveDistance;

    public RandomEngine(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    @Override
    public int accelerate() {
        int number = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
        if (number > ACCELERATION_THRESHOLD) {
            return moveDistance;
        }
        return 0;
    }
}
