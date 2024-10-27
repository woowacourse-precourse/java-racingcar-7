package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String readInput() {
        String input = Console.readLine();
        System.out.println(input);
        if (input.length() == 0) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_EMPTY);
        }
        return input;
    }
}