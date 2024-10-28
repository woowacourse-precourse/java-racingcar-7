package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.List;

/**
 * 사용자 입력 받기
 * - 경주할 자동차 이름 입력
 * - 시도할 횟수 입력
 */
public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public InputValue readInput() {
        String delimitedCarNames = readCarName();
        String attemptCount = readAttemptCount();
        List<String> carNames = inputValidator.validate(delimitedCarNames, attemptCount);

        return new InputValue(carNames, Integer.parseInt(attemptCount));
    }

    private String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
