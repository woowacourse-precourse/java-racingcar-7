package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputCarNamesValidator;

public class InputView {
    private static final String INPUT_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final InputCarNamesValidator inputCarNamesValidator = new InputCarNamesValidator();

    // TODO: 경주할 자동차를 입력받는다.
    public List<String> getInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_PROMPT);
        String InputCarNames = Console.readLine();
        return convertCarNamesToList(InputCarNames);
    }

    private List<String> convertCarNamesToList (String inputCarNames) {
        return Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .toList();
    }

    // TODO: 이동할 횟수를 입력받는다.
}