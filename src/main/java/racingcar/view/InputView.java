package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.ExceptionMessages;
import racingcar.exception.RoundException;

public class InputView {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String ROUND_FORMAT = "\\d+";

    public String getCarNames() {
        System.out.println(CAR_INPUT_MESSAGE);
        return Console.readLine();
    }

    public int getRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        String input = Console.readLine();

        if (!input.matches(ROUND_FORMAT)) {
            throw new RoundException(ExceptionMessages.INVALID_NUMBER_FORMAT.getMessage());
        }

        return Integer.parseInt(input);
    }
}

