package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RacingCarConstants;

import java.util.List;

public class RacingCar {
    private final String carName;
    private final List<Character> advanceResults;

    public String getCarName() {
        return carName;
    }

    public List<Character> getAdvanceResults() {
        return advanceResults;
    }

    public RacingCar(String carName, List<Character> advanceResult) {
        this.carName = carName;
        this.advanceResults = advanceResult;
    }

    public boolean shouldAdvance() {
        int randomInteger = Randoms.pickNumberInRange(RacingCarConstants.RANDOM_MIN, RacingCarConstants.RANDOM_MAX);
        return randomInteger >= RacingCarConstants.ADVANCE_STANDARD_NUMBER;
    }

    public void addAdvanceResult() {
        this.advanceResults.add('-');
    }
}
