package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarNames = Console.readLine();
        List<String> carNames = List.of(inputCarNames.split(","));
        return carNames;
    }

    public static int getNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
        String inputNumber = Console.readLine();
        return Integer.parseInt(inputNumber);
    }
}
