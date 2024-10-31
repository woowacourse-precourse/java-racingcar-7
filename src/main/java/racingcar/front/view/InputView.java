package racingcar.front.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.global.dto.CarRaceRequestDTO;
import racingcar.front.exception.InvalidPlayCountException;
import racingcar.front.view.message.InputViewMessage;
import racingcar.front.parser.CommaDelimiterParser;
import racingcar.front.validator.NumericValidator;

public class InputView {
    public CarRaceRequestDTO readUserInput() {
        System.out.println(InputViewMessage.INPUT_MESSAGE.getMessage());
        String carNamesInput = Console.readLine();
        System.out.println(InputViewMessage.RUN_COUNT_MESSAGE.getMessage());
        String playCountInput = Console.readLine();

        List<String> parsedCarNames = CommaDelimiterParser.parse(carNamesInput);
        if (NumericValidator.isNaturalNumber(playCountInput) == false) {
            throw new InvalidPlayCountException();
        }

        return new CarRaceRequestDTO(parsedCarNames, Integer.valueOf(playCountInput));
    }
}
