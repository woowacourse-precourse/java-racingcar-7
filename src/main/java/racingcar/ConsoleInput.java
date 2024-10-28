package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    public String inputString() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
        }
    }

    public Integer inputNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_PARSE_EXCEPTION);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
        }
    }
}
