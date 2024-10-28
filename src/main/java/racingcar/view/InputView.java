package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ErrorMessage;
import racingcar.message.InputMessage;
import racingcar.exception.RoundException;

public class InputView {
    private static final String ROUND_FORMAT = "\\d+";

    public String getCarNames() {
        System.out.println(InputMessage.CAR_INPUT.getMessage());
        return Console.readLine();
    }

    public int getRound() {
        System.out.println(InputMessage.ROUND_INPUT.getMessage());
        String input = Console.readLine();

        if (!input.matches(ROUND_FORMAT)) {
            throw new RoundException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        return Integer.parseInt(input);
    }
}
