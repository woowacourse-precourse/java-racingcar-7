package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputViewValidator;

public class InputView {
    private final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String TOTAL_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final InputViewValidator inputViewValidator = new InputViewValidator();

    public String getRacingCarNames() {
        System.out.println(NAME_MESSAGE);
        final String racingCarNames = Console.readLine();
        inputViewValidator.validateNotEmptyAndBlank(racingCarNames);
        return racingCarNames;
    }

    public String getTotalAttempts() {
        System.out.println(TOTAL_ATTEMPTS_MESSAGE);
        final String totalAttempts = Console.readLine();
        inputViewValidator.validateNotEmptyAndBlank(totalAttempts);
        inputViewValidator.validateNumeric(totalAttempts);
        return totalAttempts;
    }
}
