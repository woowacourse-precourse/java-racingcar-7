package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.config.GameConstant.CAR_NAME_DELIMITER;
import static racingcar.validator.AttemptValidator.validateAttempt;
import static racingcar.validator.CarNameValidator.validateCarName;

public class InputView {

    private InputView() {
        throw new IllegalStateException("View Class");
    }

    public static String[] getCarNames() {
        String names = getUserInput();
        String[] splitCarNames = names.split(CAR_NAME_DELIMITER, -1);
        validateCarName(splitCarNames);
        return splitCarNames;
    }

    public static int getAttempts() {
        String attempt = getUserInput();
        validateAttempt(attempt);
        return Integer.parseInt(attempt);
    }

    public static String getUserInput() {
        return readLine();
    }
}
