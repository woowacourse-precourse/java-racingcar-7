package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
        throw new IllegalStateException("View Class");
    }

    public static String[] getCarNames() {
        String names = getUserInput();
        return names.split(CAR_NAME_DELIMITER);
    }

    public static int getAttempts() {
        return Integer.parseInt(readLine());
    }

    public static String getUserInput() {
        return readLine();
    }
}
