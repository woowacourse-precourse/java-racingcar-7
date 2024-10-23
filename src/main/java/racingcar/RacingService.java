package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingService {
    private final String CAR_INPUT_DELIMITER = ",";

    public String[] convertCarInputToArray(String input) {
        return input.split(CAR_INPUT_DELIMITER);
    }

    public int createRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
