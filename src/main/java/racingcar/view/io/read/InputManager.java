package racingcar.view.io.read;

import static racingcar.common.message.InputMessage.ENTER_CAR_NAMES;
import static racingcar.common.message.InputMessage.ENTER_LAP_COUNT;
import static racingcar.util.PreprocessingUtil.replaceAllUnNecessaryChar;
import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.List;
import racingcar.view.io.write.OutputView;
import racingcar.view.validator.InputValidatorFacade;

public class InputManager {

    private InputManager() {
    }

    public static List<String> enterCarNames() {
        OutputView.print(ENTER_CAR_NAMES);
        String input = InputView.readInput();
        InputValidatorFacade.validateCarNames(input);
        return stringToStringList(input);
    }

    public static String enterLapCount() {
        OutputView.print(ENTER_LAP_COUNT);
        String input = InputView.readInput();
        InputValidatorFacade.validateLapCount(input);
        return replaceAllUnNecessaryChar(input);
    }
}
