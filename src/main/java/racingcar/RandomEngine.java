package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomEngine implements Engine {
    private static final int STAY = 0;
    private static final int FORWARD = 1;

    @Override
    public int active() {
        int randomNumber = pickNumberInRange(0, 9);
        if (isOverThanThree(randomNumber)) {
            return FORWARD;
        }
        return STAY;
    }

    private boolean isOverThanThree(int number) {
        return number >= 3;
    }
}
