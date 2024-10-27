package racingcar.app.front.model;

import static racingcar.app.front.preprocessor.input.CarNamePreprocessor.stringToStringList;
import static racingcar.app.front.preprocessor.input.LapCountPreprocessor.replaceAllUnNecessaryChar;
import static racingcar.app.front.validator.car.CarNameFacadeValidator.validateCarNames;
import static racingcar.app.front.validator.lap.LapCountFacadeValidator.validateLapCount;

import java.util.List;
import racingcar.app.front.view.InputView;
import racingcar.app.front.view.OutputView;

public class InputManager {

    private static final String ENTER_CAR_NAMES = " 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_LAP_COUNT = "시도할 횟수는 몇 회인가요?";

    private InputManager() {
    }

    private static class InputManagerHolder {
        private static final InputManager INSTANCE = new InputManager();
    }

    public static InputManager getInstance() {
        return InputManagerHolder.INSTANCE;
    }

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
