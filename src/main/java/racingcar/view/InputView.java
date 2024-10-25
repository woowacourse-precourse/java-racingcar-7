package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import racingcar.validation.InputViewValidator;

public class InputView {
    static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    static final String CAR_NAME_DELIMITER = ",";

    private final InputViewValidator inputViewValidator;

    public InputView(InputViewValidator inputViewValidator) {
        this.inputViewValidator = inputViewValidator;
    }

    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        String inputNames = Console.readLine();
        List<String> carNames = splitCarNames(inputNames);
        inputViewValidator.validateCarNames(carNames);
        return carNames;
    }

    private List<String> splitCarNames(String input) {
        inputViewValidator.validateDelimiter(input);
        return Optional.of(input)
                        .filter(name -> name.contains(CAR_NAME_DELIMITER))
                        .map(names -> Arrays.asList(input.split(CAR_NAME_DELIMITER)))
                        .orElse(Collections.singletonList(input));
    }

    public int getMoveCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        String threshold = Console.readLine();
        inputViewValidator.validateMoveCount(threshold);
        return Integer.parseInt(threshold);
    }
}
