package racingcar.view.io.read;

import static racingcar.common.message.InputMessage.ENTER_CAR_NAMES;
import static racingcar.common.message.InputMessage.ENTER_LAP_COUNT;
import static racingcar.util.PreprocessingUtil.replaceAllUnNecessaryChar;
import static racingcar.util.PreprocessingUtil.stringToStringList;
import static racingcar.view.io.read.InputView.readInput;
import static racingcar.view.io.write.OutputView.simplePrint;
import static racingcar.view.validator.InputValidatorFacade.validateCarNames;

import java.util.List;
import racingcar.view.validator.InputValidatorFacade;

public class InputManager {

    private InputManager() {
    }

    public static List<String> enterCarNames() {
        simplePrint(ENTER_CAR_NAMES);

        String input = readInput();
        validateCarNames(input);

        return stringToStringList(input);
    }

    public static String enterLapCount() {
        simplePrint(ENTER_LAP_COUNT);

        String input = readInput();
        InputValidatorFacade.validateLapCount(input);

        return replaceAllUnNecessaryChar(input);
    }
}
