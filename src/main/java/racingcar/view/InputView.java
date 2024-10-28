package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";

    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public List<Car> readCars() {
        System.out.println(INPUT_CAR_NAMES);
        final String input = Console.readLine();
        inputHandler.checkEmpty(input);
        return inputHandler.validateUniqueNames(input);
    }

    public int readAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        final String input = Console.readLine();
        final int attemptCount = inputHandler.validateNumber(input);
        inputHandler.checkMinimumCount(attemptCount);
        return attemptCount;
    }
}
