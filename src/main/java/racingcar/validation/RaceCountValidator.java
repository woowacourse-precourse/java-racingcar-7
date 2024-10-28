package racingcar.validation;

public class RaceCountValidator {

    public static void isPositiveNumber(int inputRaceCount) {
        if (inputRaceCount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
