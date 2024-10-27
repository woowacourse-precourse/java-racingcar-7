package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.config.GameConstant.CAR_NAME_DELIMITER;
import static racingcar.validator.CarNameValidator.validateCarName;

public class InputView {

    private InputView() {
        throw new IllegalStateException("View Class");
    }

    public static String[] getCarNames() {
        String names = getUserInput();
        String[] splitCarNames = names.split(CAR_NAME_DELIMITER);
        validateCarName(splitCarNames);
        return splitCarNames;
    }

    public static int getAttempts() {
        return Integer.parseInt(readLine());
    }

    public static String getUserInput() {
        return readLine();
    }
}
