package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorMessages;
import racingcar.model.Cars;
import racingcar.model.TryCount;

public class InputView {
    public static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public static Cars readCars() {
        String carNames = read(CAR_NAMES);
        return new Cars(carNames);
    }

    public static TryCount readTryCount() {
        String tryCount = read(TRY_COUNT);
        return new TryCount(tryCount);
    }

    private static String read(String message) {
        System.out.println(message);
        String input = Console.readLine();
        validateBlank(input);
        return input.trim();
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_INPUT);
        }
    }
}
