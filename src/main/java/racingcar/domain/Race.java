package racingcar.domain;

import racingcar.exception.RaceException;
import racingcar.utility.NumberUtility;

public class Race {

    private final Cars cars;
    private final String INVALID_MOVE_COUNT_MESSAGE = "유효하지 않은 시도 횟수입니다";
    private final int moveCount;

    public Race(String moveCount, Cars cars) {
        if(!isValidMoveCount(moveCount)){
            throw new RaceException(INVALID_MOVE_COUNT_MESSAGE);
        }
        this.moveCount = NumberUtility.getNumber(moveCount);
        this.cars = cars;
    }

    private boolean isValidMoveCount(String moveCount) {
        if(!NumberUtility.isNumberStr(moveCount)){
            return false;
        }

        if(!NumberUtility.isPositiveNumber(NumberUtility.getNumber(moveCount))){
            return false;
        }
        return true;
    }

}
