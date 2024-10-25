package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public List<String> inputCarName() {
        DisplayInputPrompt(INPUT_CAR_MESSAGE);
        String carNamePart = readUserInput();
        final List<String> carNames = parseCarNames(carNamePart);
        validateCarName(carNames);

        return carNames;
    }
}
