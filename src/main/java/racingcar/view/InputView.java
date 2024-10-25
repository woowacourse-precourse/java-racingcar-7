package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.InputValidator;

public class InputView {

    private final String INITIAL_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INITIAL_INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    InputValidator inputValidator = new InputValidator();

    public String inputCarName() {
        System.out.println(INITIAL_INPUT_CAR_NAME);
        final String inputCarName = Console.readLine();
        inputValidator.validateInputCarName(inputCarName);
        return inputCarName;
    }

    public String inputTryCount() {
        System.out.println(INITIAL_INPUT_TRY_COUNT);
        final String inputTryCount = Console.readLine();
        inputValidator.validateTryCount(inputTryCount);
        return inputTryCount;
    }

    public int convertStringToInt(final String tryCount) {
        return Integer.parseInt(tryCount);
    }

    public String[] splitCarName(final String carNames) {
        inputValidator.validateCarName(carNames.split(","));
        return carNames.split(",");
    }

    public void close() {
        Console.close();
    }
}