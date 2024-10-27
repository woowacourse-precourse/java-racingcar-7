package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputConverter;
import racingcar.validator.InputValidator;

import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateCarNamesInput(input);
        return InputConverter.convertNames(input);
    }

    public static Integer inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        String input = Console.readLine();
        InputValidator.validateAttemptCountInput(input);
        return InputConverter.convertCount(input);
    }
}
