package racingcar.view.io.read;

import static racingcar.common.message.InputMessage.ENTER_CAR_NAMES;
import static racingcar.common.message.InputMessage.ENTER_LAP_COUNT;
import static racingcar.util.PreprocessingUtil.replaceAllUnNecessaryChar;
import static racingcar.util.PreprocessingUtil.stringToStringList;
import static racingcar.view.validator.car.CarNameFacadeValidator.validateCarNames;
import static racingcar.view.validator.lap.LapCountFacadeValidator.validateLapCount;

import java.util.List;
import racingcar.view.io.write.OutputView;

public class InputManager {

    // Constructor
    private InputManager() {
    }

    private static class InputManagerHolder {
        private static final InputManager INSTANCE = new InputManager();
    }

    public static InputManager getInstance() {
        return InputManagerHolder.INSTANCE;
    }

    // Method
    public List<String> enterCarNames() {
        OutputView outputView = OutputView.getInstance();
        outputView.simplePrint(ENTER_CAR_NAMES);

        String input = InputView.getInstance().readInput();
        validateCarNames(input);

        return stringToStringList(input);
    }

    public long enterLapCount() {
        OutputView outputView = OutputView.getInstance();
        outputView.simplePrint(ENTER_LAP_COUNT);

        String input = InputView.getInstance().readInput();
        validateLapCount(input);

        String cleanedSource = replaceAllUnNecessaryChar(input);
        return Long.parseLong(cleanedSource);
    }
}
