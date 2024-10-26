package racingcar.common;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RaceCount;
import racingcar.model.RawInput;

public class InputController {

    public static RawInput getCarNamesInput() {
        OutputController.printCarNamePromptMessage();
        return RawInput.of(Console.readLine());
    }

    public static RaceCount getRaceCountInput() {
        OutputController.printRaceCountPromptMessage();
        return RaceCount.of(Console.readLine());
    }
}
