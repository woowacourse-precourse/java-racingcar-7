package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.InputValidator;

public class InputHandler {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return InputValidator.validateAndParseCarNames(input);
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        String validatedAttempts = InputValidator.validateAttempts(input);
        return Integer.parseInt(validatedAttempts);
    }
}
