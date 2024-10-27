package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    Valid valid = new Valid();

    public List<String> inputCarsName() {
        String rawUserInput = Console.readLine();
        return valid.validCarsName(rawUserInput);
    }

    public int inputRound() {
        String rawUserInputRound = Console.readLine();
        return valid.validRoundTime(rawUserInputRound);
    }
}
