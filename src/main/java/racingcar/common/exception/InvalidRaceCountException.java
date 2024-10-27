package racingcar.common.exception;

public class InvalidRaceCountException extends IllegalArgumentException {

    public InvalidRaceCountException(String raceCountInput) {
        super(ErrorMessage.INVALID_RACE_COUNT_INPUT + "[입력값 : " + raceCountInput + "]");
    }
}
