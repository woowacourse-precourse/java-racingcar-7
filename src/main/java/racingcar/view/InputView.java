package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputViewValidator;

public class InputView {
    private final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final InputViewValidator inputViewValidator = new InputViewValidator();

    public String getRacingCarNames() {
        System.out.println(NAME_MESSAGE);
        final String racingCarNames = Console.readLine();
        inputViewValidator.validateNotEmptyAndBlank(racingCarNames);
        return racingCarNames;
    }
}
