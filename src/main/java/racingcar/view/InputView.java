package racingcar.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.global.InputValidator.convertInputToCarNames;

public class InputView {
    public static List<String> readCarNames() {
        String input = readLine();
        return convertInputToCarNames(input);
    }
}
