package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

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

    public int getRandomOrZero() {
        int randomInteger = Randoms.pickNumberInRange(0, 9);
        if (randomInteger < 4) {
            return 0;
        }
        return randomInteger;
    }

    public void addRandomAdvanceResult(int randomInteger) {
        for (int i = 0; i < randomInteger; i++) {
            this.advanceResults.add('-');
        }
    }
}