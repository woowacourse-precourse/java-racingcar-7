package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RoundException;
import racingcar.message.ErrorMessage;
import racingcar.message.InputMessage;
import racingcar.message.PatternMessage;
import racingcar.dto.InputRequest;

import java.util.Optional;

public class InputView {

    public InputRequest getInput() {
        System.out.println(InputMessage.CAR_INPUT.getMessage());
        String carNames = Console.readLine();

        System.out.println(InputMessage.ROUND_INPUT.getMessage());
        int roundCount = validateAndParseRound(Console.readLine());

        return InputRequest.of(carNames, roundCount);
    }

    private int validateAndParseRound(String input) {
        return Optional.of(input)
                .filter(PatternMessage.VALID_FORMAT::matches)
                .map(Integer::parseInt)
                .orElseThrow(() -> new RoundException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage()));
    }

    private int throwRoundException() {
        throw new RoundException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }
}