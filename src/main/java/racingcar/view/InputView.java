package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validation;

public class InputView {
    private final Validation validation = new Validation();
    private final String GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String GET_ROUND_LIMIT = "시도할 횟수는 몇 회인가요?";

    public String[] getCarNames() {
        System.out.println(GET_CAR_NAME);
        String input = Console.readLine();
        return validation.validateCarName(input);
    }

    public int getRoundLimit() {
        System.out.println(GET_ROUND_LIMIT);
        String input = Console.readLine();
        return validation.validateRoundLimit(input);
    }
}
