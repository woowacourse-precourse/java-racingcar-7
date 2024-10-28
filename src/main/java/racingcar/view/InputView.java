package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RoundException;
import racingcar.message.ErrorMessage;
import racingcar.message.InputMessage;
import racingcar.message.PatternMessage;

import java.util.Optional;

public class InputView {

    public String getCarNames() {
        System.out.println(InputMessage.CAR_INPUT.getMessage());
        return Console.readLine();
    }

    public int getRound() {
        System.out.println(InputMessage.ROUND_INPUT.getMessage());
        String input = Console.readLine();

        return validateAndParseRound(input);
    }

    private int validateAndParseRound(String input) {
        return Optional.of(input)
                .filter(PatternMessage.VALID_FORMAT::matches)
                .map(Integer::parseInt)
                .orElseThrow(() -> new RoundException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage()));
    }
}