package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(DELIMITER);
        return carNames;
    }
}
