package racingcar.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.global.InputValidator.convertInputToCarNames;
import static racingcar.global.InputValidator.convertInputToInteger;

public class InputView {
    public static List<String> readCarNames() {
        String input = readLine();
        return convertInputToCarNames(input);
    }

    public static int readTotalAttempt() {
        String input = readLine();
        try {
            return convertInputToInteger(input);
        } catch (IllegalArgumentException e) {
            OutputView.printTotalAttemptInputMessage();
            return readTotalAttempt();
        }
    }
}
