package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputCarNamesValidator;
import racingcar.validator.InputCountValidator;

public class InputView {
    private static final String INPUT_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private final InputCarNamesValidator inputCarNamesValidator = new InputCarNamesValidator();
    private final InputCountValidator inputCountValidator = new InputCountValidator();

    public List<String> getInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_PROMPT);
        String InputCarNames = Console.readLine();
        return convertCarNamesToList(InputCarNames);
    }

    public int getInputTryCount() {
        System.out.println(INPUT_TRY_COUNT_PROMPT);
        String InputTryCount = Console.readLine();
        Console.close();
        return convertTryCountToInt(InputTryCount);
    }

    private List<String> convertCarNamesToList(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(","))
                .map(String::trim)
                .filter(inputCarNamesValidator::isNotCarNameEmpty)
                .filter(inputCarNamesValidator::isCarNameLengthValid)
                .filter(inputCarNamesValidator::isNotDuplicateCarName)
                .toList();
    }

    private int convertTryCountToInt(String inputTryCount) {
        int tryCount = 0;
        if (inputCountValidator.isNotBlankTryCount(inputTryCount)) {

        }
        if (inputCountValidator.isValidScope(inputTryCount)) {
            tryCount = Integer.parseInt(inputTryCount);
        }
        if (inputCountValidator.isAboveMinimumTryCount(tryCount)) {

        }
        return tryCount;
    }
}