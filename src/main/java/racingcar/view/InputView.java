package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    public List<String> inputCarNames() {
        String carNames = Console.readLine();

        validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        return Convertor.toList(splitCarNames);
    }

    public int inputRacingCount() {
        String racingCount = Console.readLine();

        validateRacingCount(racingCount);

        return Integer.parseInt(racingCount);
    }

    private void validateCarNames(String carNames) {
        if (InputValidation.validateNullOrEmpty(carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if (InputValidation.validateBlank(carNames)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private void validateRacingCount(String racingCount) {
        if (InputValidation.validateNullOrEmpty(racingCount)) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        if (InputValidation.validateBlank(racingCount)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private String[] carNameSplit(String carNames) {
        return carNames.split(",");
    }
}
