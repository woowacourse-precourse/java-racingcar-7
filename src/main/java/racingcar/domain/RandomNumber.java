package racingcar.domain;

import static racingcar.common.Constants.MAX_RANDOM_NUMBER;
import static racingcar.common.Constants.MIN_RANDOM_NUMBER;
import static racingcar.common.Constants.MOVE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final Integer randomNumber;

    public RandomNumber() {
        this.randomNumber = generateRandomNumber();
    }

    public RandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }


    public boolean isMove() {
        return randomNumber >= MOVE_NUMBER;
    }

    public boolean validRandomNumber () {
        return randomNumber >= MIN_RANDOM_NUMBER && randomNumber <= MAX_RANDOM_NUMBER;
    }

    private Integer generateRandomNumber () {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
