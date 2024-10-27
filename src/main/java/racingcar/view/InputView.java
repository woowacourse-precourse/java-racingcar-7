package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidation;
import racingcar.util.Convertor;

public class InputView {

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        InputValidation.validateCarNames(carNames);

        String[] splitCarNames = carNameSplit(carNames);
        InputValidation.validateDelimiter(splitCarNames);

        return Convertor.toList(splitCarNames);
    }

    public int inputRacingCount() {
        String racingCount = Console.readLine();
        InputValidation.validateRacingCount(racingCount);

        return toInt(racingCount);
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
