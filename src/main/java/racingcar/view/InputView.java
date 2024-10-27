package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.parser.InputParser;

public class InputView {

    public static CarNameRequest getCarName() {
        String carNames = Console.readLine();
        return InputParser.parseCarName(carNames);
    }

    public static TryNumberRequest getTryNumber() {
        String tryNumber = Console.readLine();
        return InputParser.parseTryNumber(tryNumber);
    }

}
