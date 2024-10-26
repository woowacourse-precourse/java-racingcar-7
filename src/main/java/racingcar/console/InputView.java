package racingcar.console;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();

        inputValidator.validateNameFormat(names);

        return names;
    }

    public int inputLap() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String lap = Console.readLine();

        inputValidator.validateNumeric(lap);

        return Integer.parseInt(lap);
    }
}
