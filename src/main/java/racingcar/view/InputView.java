package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.CarNameValidator;
import racingcar.validator.MoveCountValidator;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String COMMA_DELIMITER = ",";

    public InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarNames = Console.readLine();
        CarNameValidator.validate(inputCarNames);
        return List.of(inputCarNames.split(COMMA_DELIMITER));
    }

    public static int getNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
        String inputNumber = Console.readLine();
        MoveCountValidator.validate(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
