package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static racingcar.message.ErrorMessage.NEGATIVE_NUMBER_ERROR;
import static racingcar.message.InfoMessage.REQUEST_NUMBER_MESSAGE;
import static racingcar.utils.ExceptionUtils.throwException;

public class NumberRequestHandler {
    public int getNumber() {
        System.out.println(REQUEST_NUMBER_MESSAGE.getMessage());
        String inputString = Console.readLine();
        int rawNumber = convertToInteger(inputString);
        validateNegative(rawNumber);
        return rawNumber;
    }

    public int convertToInteger(String rawNumber) {
        if (rawNumber.matches("\\d+")) {
            return Integer.parseInt(rawNumber);
        } else {
            throwException(INVALID_NUMBER_ERROR);
            return 0;
        }
    }

    public void validateNegative(int rawNumber) {
        if (rawNumber < 0) {
            throwException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
