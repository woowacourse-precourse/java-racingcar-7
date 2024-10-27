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
        List<String> carNames = inputValidator.validateDelimitedCarNames(delimitedCarNames);
        try {
            int attemptCount = readAttemptCount();
            if (attemptCount < 0) {
                throw new IllegalArgumentException("시도 횟수로는 음이 아닌 정수를 입력해주세요");
            }
            return new InputValue(carNames, attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수로는 음이 아닌 정수를 입력해주세요");
        }
    }

    private String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine()); // 숫자가 아닌 경우 자체적으로 IllegalArgumentException 예외 던짐
    }
}
