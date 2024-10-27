package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    private static final String NOT_CONTAIN_BLANK_MESSAGE = "공백을 입력할 수 없습니다.";

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        validateDelimiter(splitCarNames);

        return Convertor.toList(splitCarNames);
    }

    public int inputRacingCount() {
        String racingCount = Console.readLine();
        validateRacingCount(racingCount);

        return toInt(racingCount);
    }

    private void validateCarNames(String carNames) {
        validateInput(carNames, "자동차 이름을 입력해야 합니다.");
    }

    private void validateDelimiter(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            validateInput(splitCarName, "구분자를 연속해서 입력할 수 없습니다.");
        }
    }

    private void validateRacingCount(String racingCount) {
        validateInput(racingCount, "시도 횟수를 입력해야 합니다.");
    }

    private void validateInput(String input, String exceptionMessage) {
        if (InputValidation.validateNullOrEmpty(input)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        if (InputValidation.validateBlank(input)) {
            throw new IllegalArgumentException(NOT_CONTAIN_BLANK_MESSAGE);
        }
    }

    private String[] carNameSplit(String carNames) {
        return carNames.split(",");
    }

    private int toInt(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도 횟수는 1이상의 정수로 입력해야 합니다.");
        }
    }
}
