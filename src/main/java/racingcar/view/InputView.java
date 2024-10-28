package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        InputValidator.validateEmpty(input);
        InputValidator.validateEndIsAlphbetorNumber(input);
        return Arrays.asList(input.split(","));
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return InputValidator.parsePositiveNumberWithValidation(input);
    }
}
