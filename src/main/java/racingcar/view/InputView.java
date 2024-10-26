package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNameRequest;
import racingcar.parser.CarNameParser;

public class InputView {

    public static CarNameRequest getCarName() {
        String carNames = Console.readLine();
        return CarNameParser.parseCarName(carNames);
    }

}
