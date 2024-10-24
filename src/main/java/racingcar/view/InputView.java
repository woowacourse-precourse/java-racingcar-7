package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import racingcar.validation.InputViewValidator;

public class InputView {
    static final String MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String MESSAGE_MOVE_COUNT = "시도할 횟수는 몇 회인가요?";
    static final String DELIMITER = ",";

    private final InputViewValidator inputViewValidator;

    public InputView(InputViewValidator inputViewValidator) {
        this.inputViewValidator = inputViewValidator;
    }

    public List<String> getCarNames() {
        System.out.println(MESSAGE_CAR_NAMES);
        String inputNames = Console.readLine();
        List<String> carNames = splitCarNames(inputNames);
        inputViewValidator.validateCarNames(carNames);
        return carNames;
    }

    private List<String> splitCarNames(String input) {
        inputViewValidator.validateDelimiter(input);
        return Optional.of(input)
                        .filter(name -> name.contains(DELIMITER))
                        .map(names -> Arrays.asList(input.split(DELIMITER)))
                        .orElse(Collections.singletonList(input));
    }

    public int getMoveThreshold() {
        System.out.println(MESSAGE_MOVE_COUNT);
        String threshold = Console.readLine();
        inputViewValidator.validateMoveThreshold(threshold);
        return Integer.parseInt(threshold);
    }
}
