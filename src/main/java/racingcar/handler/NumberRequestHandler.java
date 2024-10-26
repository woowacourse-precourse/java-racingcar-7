package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.ErrorMessage.INVALID_NUMBER_ERROR;
import static racingcar.message.ErrorMessage.NEGATIVE_NUMBER_ERROR;
import static racingcar.utils.ExceptionUtils.throwException;

public class NumberRequestHandler {
    public int getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputString = Console.readLine();
        int rawNumber = convertToInteger(inputString);
        validateNegative(rawNumber);
        return rawNumber;
    }

    public int convertToInteger(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throwException(NEGATIVE_NUMBER_ERROR);
            return 0;
        }
    }

    private void validateNegative(int rawNumber) {
        if (rawNumber < 0) {
            throwException(INVALID_NUMBER_ERROR);
        }
    }
}
