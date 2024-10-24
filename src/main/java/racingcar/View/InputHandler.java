package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    List<String> carNames;

    public InputHandler() {
        carNames = new ArrayList<>();
    }

    public List<String> carNames() {
        String userInput = Console.readLine();

        String[] splitCarNames = userInput.split(",");
        carNames.addAll(Arrays.asList(splitCarNames));

        return carNames;
    }
}
