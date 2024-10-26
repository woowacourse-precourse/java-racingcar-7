package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.message.ErrorMessage.INVALID_NUMBER_ERROR;

public class NumberRequestHandler {
    public int getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputString = Console.readLine();
        int rawNumber = convertToInteger(inputString);
        return 0;
    }

    public int convertToInteger(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            String errorMessage = INVALID_NUMBER_ERROR.getMessage();
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
