package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputCarNames() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public Integer inputNumberOfMoves() {
        String input = Console.readLine();
        InputValidation.checkIsNumber(input);

        return Integer.parseInt(input);
    }
}
