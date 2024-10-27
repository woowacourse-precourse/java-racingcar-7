package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumGenerator {

    public static int generateRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
