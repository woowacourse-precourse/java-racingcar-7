package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Moving {
    private int randomValueExtraction() {
        return pickNumberInRange(0, 9);
    }

    public boolean forward() {
        int randomValue = randomValueExtraction();
        return randomValue >= 4;
    }
}
