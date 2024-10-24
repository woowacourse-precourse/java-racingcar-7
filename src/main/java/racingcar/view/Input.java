package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.Validation;

public class Input {

    private final Validation validation;

    public Input(Validation validation) {
        this.validation = validation;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return validation.validateCarNameInput(input);
    }
}
