package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomEngine implements Engine {
    private static final int STOP = 0;
    private static final int MOVING_FORWARD = 1;

    @Override
    public int active() {
        int randomNumber = pickNumberInRange(0, 9);
        if (isOverThanThree(randomNumber)) {
            return MOVING_FORWARD;
        }
        return STOP;
    }

    private boolean isOverThanThree(int number) {
        return number >= 3;
    }
}
