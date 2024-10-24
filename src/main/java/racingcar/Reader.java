package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String readInput() {
        String input = Console.readLine();
        System.out.println("input value: " + input);
        if (input.length() == 0) {
            Printer.printMessage(Constants.INPUT_ERROR_EMPTY);
            throw new IllegalArgumentException();
        }
        return input;
    }
}