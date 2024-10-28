package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

public class InputView {

    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(CAR_NAME_INPUT);
        return Console.readLine();
    }

    public int readTryCount() {
        System.out.println(COUNT_INPUT);
        String input = Console.readLine();
        System.out.println();
        return Validator.parseInteger(input);
    }
}
