package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.ErrorMessage.NOT_NUMBER;
import static racingcar.ErrorMessage.NOT_POSITIVE_NUMBER;
import static racingcar.ErrorMessage.ONE_CAR_NAME;
import static racingcar.ErrorMessage.TOO_BIG_NUMBER;
import static racingcar.ErrorMessage.TOO_LONG_CAR_NAME;
import static racingcar.TextString.NAME_SEPARATOR;

public class ReadUserInputView {
    public String[] readRacingCarNames() {
        var carNames = readLine().split(NAME_SEPARATOR.getText());
        if (!UserInputValidator.isOneRacingCar(carNames)) {
            throw new IllegalArgumentException(ONE_CAR_NAME.getMessage());
        }
        if (!UserInputValidator.isValidRacingCarName(carNames)) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME.getMessage());
        }
        return carNames;
    }

    public long readTryCount() {
        var tryCount = readLine();
        if (!UserInputValidator.isNumberTryCount(tryCount)) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        if (!UserInputValidator.isNotTooBigTryCount(tryCount)) {
            throw new IllegalArgumentException(TOO_BIG_NUMBER.getMessage());
        }
        if (!UserInputValidator.isPositiveTryCount(tryCount)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER.getMessage());
        }
        return Long.parseLong(tryCount);
    }
}
