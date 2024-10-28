package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.RequestView;

import static racingcar.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static racingcar.message.ErrorMessage.NEGATIVE_NUMBER_ERROR;
import static racingcar.utils.ExceptionUtils.throwException;

public class NumberRequestHandler {

    public long getNumber() {
        RequestView.requestMoveNumber();
        String inputString = Console.readLine();
        long number = convertToLong(inputString);
        validateNegative(number);
        return number;
    }

    public long convertToLong(String rawNumber) {
        if (rawNumber.matches("\\d+")) {
            return Long.parseLong(rawNumber);
        }
        throwException(INVALID_NUMBER_ERROR);
        return -1L;
    }

    public void validateNegative(long rawNumber) {
        if (rawNumber < 0) {
            throwException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
